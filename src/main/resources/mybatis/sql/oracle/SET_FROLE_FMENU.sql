prompt PL/SQL Developer import file
prompt Created on 2015年11月16日 by Administrator
set feedback off
set define off
prompt Creating SET_FROLE_FMENU...
create table SET_FROLE_FMENU
(
  FUNC_ROLE_ID     NUMBER not null,
  FUNC_MENU_ID     NUMBER not null,
  LAST_UPDATOR     VARCHAR2(32),
  LAST_UPDATE_TIME TIMESTAMP(6)
);

comment on table SET_FROLE_FMENU is '功能角色功能菜单关系表';

alter table SET_FROLE_FMENU add constraint PK_SET_FROLE_FMENU primary key (FUNC_ROLE_ID, FUNC_MENU_ID);

prompt Loading SET_FROLE_FMENU...
insert into SET_FROLE_FMENU (FUNC_ROLE_ID, FUNC_MENU_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10038, 10050, null, null);
insert into SET_FROLE_FMENU (FUNC_ROLE_ID, FUNC_MENU_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10038, 10052, null, null);
insert into SET_FROLE_FMENU (FUNC_ROLE_ID, FUNC_MENU_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10038, 10051, null, null);
insert into SET_FROLE_FMENU (FUNC_ROLE_ID, FUNC_MENU_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10038, 10054, null, null);
insert into SET_FROLE_FMENU (FUNC_ROLE_ID, FUNC_MENU_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10038, 10055, null, null);
insert into SET_FROLE_FMENU (FUNC_ROLE_ID, FUNC_MENU_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10038, 10053, null, null);
insert into SET_FROLE_FMENU (FUNC_ROLE_ID, FUNC_MENU_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10038, 10056, null, null);
insert into SET_FROLE_FMENU (FUNC_ROLE_ID, FUNC_MENU_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10038, 10057, null, null);
commit;
prompt 8 records loaded
set feedback on
set define on
prompt Done.
