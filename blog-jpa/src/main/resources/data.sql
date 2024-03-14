create table if not exists Article (
    id BIGINT AUTO_INCREMENT primary key,
    title varchar(255) not null,
    content varchar(255) not null,
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    updatedAt timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
INSERT INTO Article(title,content) VALUES('컨텐츠1','컨텐츠내용1');
INSERT INTO Article(title,content) VALUES('컨텐츠2','컨텐츠내용2');
INSERT INTO Article(title,content) VALUES('컨텐츠3','컨텐츠내용3');
