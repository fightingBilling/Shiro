prompt PL/SQL Developer import file
prompt Created on 2015年11月16日 by Administrator
set feedback off
set define off
prompt Creating SET_USER...
create table SET_USER
(
  USER_ID          NUMBER not null,
  USERNAME         VARCHAR2(32) not null,
  PASSWORD         VARCHAR2(32) not null,
  DESCRIPTION      VARCHAR2(256),
  STATUS           CHAR(1) not null,
  LAST_UPDATOR     VARCHAR2(32),
  LAST_UPDATE_TIME TIMESTAMP(6)
);

comment on table SET_USER is '用户表';

alter table SET_USER add constraint PK_SET_USER primary key (USER_ID);

alter table SET_USER add constraint SET_USER_IX1 unique (USERNAME);

prompt Loading SET_USER...
insert into SET_USER (USER_ID, USERNAME, PASSWORD, DESCRIPTION, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10023, 'admin', '68cf63c62bc68d71fc41c028375e2f6e', null, '1', 'admin', to_timestamp('03-11-2015 10:02:32.507000', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;
prompt 1 records loaded
set feedback on
set define on
prompt Done.
