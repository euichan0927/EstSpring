create table if not exists article (
    id BIGINT AUTO_INCREMENT primary key,
    title varchar(255) not null,
    content varchar(255) not null
);
INSERT INTO article(title,content) VALUES('컨텐츠1','컨텐츠내용1');
INSERT INTO article(title,content) VALUES('컨텐츠2','컨텐츠내용2');
INSERT INTO article(title,content) VALUES('컨텐츠3','컨텐츠내용3');
