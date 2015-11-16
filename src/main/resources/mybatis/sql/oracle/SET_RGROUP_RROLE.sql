prompt PL/SQL Developer import file
prompt Created on 2015年11月16日 by Administrator
set feedback off
set define off
prompt Creating SET_RGROUP_RROLE...
create table SET_RGROUP_RROLE
(
  RGROUP_ID        NUMBER not null,
  RESOURCE_ROLE_ID NUMBER not null,
  LAST_UPDATOR     VARCHAR2(32),
  LAST_UPDATE_TIME TIMESTAMP(6)
);

comment on table SET_RGROUP_RROLE is '角色组-资源角色关系表';

alter table SET_RGROUP_RROLE add constraint PK_SET_RGROUP_RROLE primary key (RGROUP_ID, RESOURCE_ROLE_ID);

prompt Loading SET_RGROUP_RROLE...

insert into SET_RGROUP_RROLE (RGROUP_ID, RESOURCE_ROLE_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10048, 10046, null, null);

commit;
prompt 1 records loaded
set feedback on
set define on
prompt Done.
