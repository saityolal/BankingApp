CREATE TABLE IF NOT EXISTS `cards`
(
    `card_id` int NOT NULL AUTO_INCREMENT,
    `mobile_number` VARCHAR(15) NOT NULL,
    `card_number` VARCHAR(100) NOT NULL,
    `card_type` VARCHAR(100) NOT NULL,
    `total_limit` int NOT NULL,
    `amount_used` int NOT NULL,
    `available_amount` int NOT NULL,
    `created_at` DATETIME NOT NULL,  -- DATE yerine DATETIME yapıldı
    `created_by` VARCHAR(20) NOT NULL,
    `updated_at` DATETIME DEFAULT NULL,  -- DATE yerine DATETIME yapıldı
    `updated_by` VARCHAR(20) DEFAULT NULL,
    PRIMARY KEY(`card_id`)
    );