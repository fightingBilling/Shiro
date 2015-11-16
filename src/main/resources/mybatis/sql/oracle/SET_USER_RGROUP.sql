prompt PL/SQL Developer import file
prompt Created on 2015年11月16日 by Administrator
set feedback off
set define off
prompt Creating SET_USER_RGROUP...
create table SET_USER_RGROUP
(
  USER_ID          NUMBER not null,
  RGROUP_ID        NUMBER not null,
  LAST_UPDATOR     VARCHAR2(32),
  LAST_UPDATE_TIME TIMESTAMP(6)
);

comment on table SET_USER_RGROUP is '用户-角色组关系表';

alter table SET_USER_RGROUP add constraint PK_SET_USER_RGROUP primary key (USER_ID, RGROUP_ID);

prompt Loading SET_USER_RGROUP...
insert into SET_USER_RGROUP (USER_ID, RGROUP_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10023, 10048, null, null);
commit;
prompt 1 records loaded
set feedback on
set define on
prompt Done.
