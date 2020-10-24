USE penguinhouse;

DROP TABLE IF EXISTS `users`;

CREATE TABLE IF NOT EXISTS `users` (
  `id`                INT(20) AUTO_INCREMENT,
  `name`              VARCHAR(20) NOT NULL,
  `created_at`        Datetime DEFAULT NULL,
  `updated_at`        Datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;
