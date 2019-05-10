CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `money` bigint(20) NOT NULL COMMENT '余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `transfer_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `from_user_id` bigint(20) NOT NULL COMMENT '转账人id',
  `change_money` bigint(20) NOT NULL COMMENT '转账金额',
  `transaction_id` varchar(128) NOT NULL COMMENT '消息事务id',
  `to_user_id` bigint(20) NOT NULL COMMENT '被转账人id',
  `record_no` varchar(64) NOT NULL COMMENT '转账流水编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_record_no` (`record_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO `user`(`id`, `money`) VALUES (1, 100);
INSERT INTO `user`(`id`, `money`) VALUES (2, 0);