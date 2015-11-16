prompt PL/SQL Developer import file
prompt Created on 2015年11月16日 by Administrator
set feedback off
set define off
prompt Creating SET_RROLE_RESOURCE...
create table SET_RROLE_RESOURCE
(
  RESOURCE_ROLE_ID NUMBER not null,
  RESOURCE_ID      NUMBER not null,
  LAST_UPDATOR     VARCHAR2(32),
  LAST_UPDATE_TIME TIMESTAMP(6)
);

comment on table SET_RROLE_RESOURCE is '资源角色-资源关系';

alter table SET_RROLE_RESOURCE add constraint PK_SET_RROLE_RESOURCE primary key (RESOURCE_ROLE_ID, RESOURCE_ID);

prompt Loading SET_RROLE_RESOURCE...
insert into SET_RROLE_RESOURCE (RESOURCE_ROLE_ID, RESOURCE_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10046, 992, null, null);
insert into SET_RROLE_RESOURCE (RESOURCE_ROLE_ID, RESOURCE_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10046, 993, null, null);
insert into SET_RROLE_RESOURCE (RESOURCE_ROLE_ID, RESOURCE_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10046, 994, null, null);
insert into SET_RROLE_RESOURCE (RESOURCE_ROLE_ID, RESOURCE_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10046, 995, null, null);
insert into SET_RROLE_RESOURCE (RESOURCE_ROLE_ID, RESOURCE_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10046, 996, null, null);
insert into SET_RROLE_RESOURCE (RESOURCE_ROLE_ID, RESOURCE_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10046, 997, null, null);

commit;
prompt 6 records loaded
set feedback on
set define on
prompt Done.
