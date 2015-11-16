prompt PL/SQL Developer import file
prompt Created on 2015年11月16日 by Administrator
set feedback off
set define off
prompt Creating SET_RESOURCE...
create table SET_RESOURCE
(
  RESOURCE_ID      NUMBER not null,
  SECURITY_FILTER  VARCHAR2(15) not null,
  URL_PATTERN      VARCHAR2(384) not null,
  STATUS           CHAR(1) not null,
  LAST_UPDATOR     VARCHAR2(32),
  LAST_UPDATE_TIME TIMESTAMP(6)
);

comment on table SET_RESOURCE is '资源授权表';

comment on column SET_RESOURCE.STATUS is '0-禁用，1-启用';

alter table SET_RESOURCE add constraint PK_SET_RESOURCE primary key (RESOURCE_ID);

prompt Loading SET_RESOURCE...
insert into SET_RESOURCE (RESOURCE_ID, SECURITY_FILTER, URL_PATTERN, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (997, 'cAuthc', '/mt/menu/menu_read.html', '1', null, null);
insert into SET_RESOURCE (RESOURCE_ID, SECURITY_FILTER, URL_PATTERN, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (996, 'cAuthc', '/mt/resource/resource_read.html', '1', null, null);
insert into SET_RESOURCE (RESOURCE_ID, SECURITY_FILTER, URL_PATTERN, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (992, 'cAuthc', '/mt/rgroup/rgroup_read.html', '1', null, null);
insert into SET_RESOURCE (RESOURCE_ID, SECURITY_FILTER, URL_PATTERN, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (995, 'cAuthc', '/mt/role/role_menu_read.html', '1', null, null);
insert into SET_RESOURCE (RESOURCE_ID, SECURITY_FILTER, URL_PATTERN, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (994, 'cAuthc', '/mt/role/role_resource_read.html', '1', null, null);
insert into SET_RESOURCE (RESOURCE_ID, SECURITY_FILTER, URL_PATTERN, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (993, 'cAuthc', '/mt/user/user_read.html', '1', null, null);
insert into SET_RESOURCE (RESOURCE_ID, SECURITY_FILTER, URL_PATTERN, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (999, 'cAuthc', '/default.html', '1', null, null);
commit;
prompt 7 records loaded
set feedback on
set define on
prompt Done.
