/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.company.project.biz;

import com.alibaba.fastjson.JSON;
import com.company.project.biz.entity.TransferRecord;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TransactionListenerImpl implements TransactionListener {
    @Resource
    private BusinessService businessService;


    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        TransferRecord transferRecord = JSON.parseObject(msg.getBody(), TransferRecord.class);
        LocalTransactionState state = LocalTransactionState.UNKNOW;
        try {
            boolean isCommit = businessService.doTransfer(transferRecord.getFromUserId(),transferRecord.getToUserId()
                    ,transferRecord.getChangeMoney(),transferRecord.getRecordNo(),msg.getTransactionId());
            if (isCommit) {
                state = LocalTransactionState.COMMIT_MESSAGE;
            } else {
                state = LocalTransactionState.ROLLBACK_MESSAGE;
            }
        } catch (Exception e) {
            System.out.println("转账失败,fromUserId:"+transferRecord.getFromUserId()+",toUserId:"+transferRecord.getToUserId()+",money:"+transferRecord.getChangeMoney());
            e.printStackTrace();
        }

        return state;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        LocalTransactionState state = LocalTransactionState.UNKNOW;
        try {
            boolean isCommit = businessService.checkTransferStatus(msg.getTransactionId());
            if (isCommit) {
                state = LocalTransactionState.COMMIT_MESSAGE;
            } else {
                state = LocalTransactionState.ROLLBACK_MESSAGE;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }
}
