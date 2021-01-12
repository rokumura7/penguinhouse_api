USE penguinhouse;

CREATE TABLE IF NOT EXISTS `users` (
  `user_id`           BIGINT UNSIGNED AUTO_INCREMENT,
  `google_id`         BIGINT UNSIGNED NOT NULL UNIQUE,
  `name`              VARCHAR(60) NOT NULL,
  `email`             VARCHAR(255),
  `image_url`         VARCHAR(255),
  `memo`              TEXT,
  `created_at`        TIMESTAMP,
  `updated_at`        TIMESTAMP,
  PRIMARY KEY (`user_id`)
) DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `contents` (
  `content_id`        BIGINT UNSIGNED AUTO_INCREMENT,
  `title`             VARCHAR(255) NOT NULL,
  `description`       TEXT,
  `status_id`         BIGINT UNSIGNED NOT NULL,
  `created_by`        BIGINT UNSIGNED NOT NULL,
  `updated_by`        BIGINT UNSIGNED NOT NULL,
  `created_at`        TIMESTAMP NOT NULL,
  `updated_at`        TIMESTAMP NOT NULL,
  `target_date`       TIMESTAMP DEFAULT NULL,
  `completed_at`      TIMESTAMP DEFAULT NULL,
  `display_order`     BIGINT UNSIGNED,
  PRIMARY KEY (`content_id`)
) DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `contents_categories` (
  `content_id`        BIGINT UNSIGNED NOT NULL,
  `category_id`       BIGINT UNSIGNED NOT NULL
) DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `categories` (
  `category_id`       BIGINT UNSIGNED AUTO_INCREMENT,
  `name`              VARCHAR(60) NOT NULL,
  `color`             VARCHAR(60),
  PRIMARY KEY (`category_id`)
) DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `statuses` (
  `status_id`         BIGINT UNSIGNED AUTO_INCREMENT,
  `name`              VARCHAR(60) NOT NULL,
  `display_order`     BIGINT UNSIGNED,
  PRIMARY KEY (`status_id`)
) DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `comments` (
  `comment_id`        BIGINT UNSIGNED AUTO_INCREMENT,
  `content_id`        BIGINT UNSIGNED NOT NULL,
  `comment`           TEXT NOT NULL,
  `created_by`        BIGINT UNSIGNED NOT NULL,
  `created_at`        TIMESTAMP NOT NULL,
  `updated_at`        TIMESTAMP NOT NULL,
  PRIMARY KEY(`comment_id`)
) DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `images` (
  `image_id`          BIGINT UNSIGNED AUTO_INCREMENT,
  `title`             VARCHAR(255) NOT NULL,
  `uploaded_by`       BIGINT UNSIGNED NOT NULL,
  `uploaded_at`       TIMESTAMP NOT NULL,
  `created_at`        TIMESTAMP NOT NULL,
  `content_created_at` TIMESTAMP NOT NULL,
  `image_url`         VARCHAR(255) NOT NULL,
  `content_id`        BIGINT UNSIGNED,
  `comment_id`        BIGINT UNSIGNED,
  `is_cover_image`    TINYINT(1),
  PRIMARY KEY(`image_id`)
) DEFAULT CHARSET=utf8;