create table last_menu(
	typeId number(3) primary key,
	typeName varchar2(40),
	typeLevel number(2),
	typeFid number(2)
)
create sequence last_menu_seq
drop table last_menu
drop sequence last_menu_seq
select * from last_menu

select l1.typeId,l1.typeName,l1.typeLevel,l1.typeFid,l2.typeId,l2.typeName,l2.typeLevel,l2.typeFid
from last_menu l1 inner join last_menu l2
on l1.typeId = l2.typeFid

	select 
  		l1.typeId as l1id,
  		l1.typeName as l1name,
  		l1.typeLevel as l1level,
  		l1.typeFid as l1fid,
  		l2.typeId as l2id,
  		l2.typeName as l2name,
  		l2.typeLevel as l2level,
  		l2.typeFid as l2fid
		from last_menu l1 inner join last_menu l2
		on l1.typeId = l2.typeFid

insert into last_menu values(last_menu_seq.nextval,'妙音管理',1,null);
insert into last_menu values(last_menu_seq.nextval,'妙宝管理',1,null);
insert into last_menu values(last_menu_seq.nextval,'用户管理',1,null);
insert into last_menu values(last_menu_seq.nextval,'上师管理',1,null);
insert into last_menu values(last_menu_seq.nextval,'功课管理',1,null);
insert into last_menu values(last_menu_seq.nextval,'轮播图管理',1,null);
insert into last_menu values(last_menu_seq.nextval,'专辑管理',2,1);
insert into last_menu values(last_menu_seq.nextval,'音频管理',2,1);
insert into last_menu values(last_menu_seq.nextval,'文章管理',2,2);
insert into last_menu values(last_menu_seq.nextval,'用户信息管理',2,3);
insert into last_menu values(last_menu_seq.nextval,'用户状态管理',2,3);
insert into last_menu values(last_menu_seq.nextval,'上师信息管理',2,4);
insert into last_menu values(last_menu_seq.nextval,'上师状态管理',2,4);
insert into last_menu values(last_menu_seq.nextval,'功课管理',2,5);
insert into last_menu values(last_menu_seq.nextval,'计数器管理',2,5);
insert into last_menu values(last_menu_seq.nextval,'添加轮播图',2,6);
insert into last_menu values(last_menu_seq.nextval,'轮播图状态管理',2,6);