#如果复制到mysql中执行时 加上
#DELIMITER ;;

drop table if exists `SYS_USER`;;
drop table if exists `SYS_ORGANIZATION`;;

drop table if exists `SYS_USER_ORGANIZATION_JOB`;;
drop table if exists `SYS_RESOURCE`;;
drop table if exists `SYS_PERMISSION`;;
drop table if exists `SYS_ROLE`;;
drop table if exists `SYS_ROLE_RESOURCE_PERMISSION`;;
drop table if exists `SYS_GROUP`;;
drop table if exists `SYS_GROUP_RELATION`;;
drop table if exists `SYS_AUTH`;;
##user
create table `SYS_USER`(
  `ID`         bigint not null auto_increment,
  `USERNAME`  varchar(100),
  `EMAIL`  varchar(100),
  `MOBILE_PHONE_NUMBER`  varchar(20),
  `PASSWORD`  varchar(100),
  `SALT`       varchar(10),
  `CREATE_DATE` timestamp default 0,
  `STATUS`    varchar(50),
  `DELETED`   bool,
  `ADMIN`     bool,
  constraint `pk_sys_user` primary key(`ID`),
  constraint `unique_sys_user_username` unique(`USERNAME`),
  constraint `unique_sys_user_email` unique(`EMAIL`),
  constraint `unique_sys_user_mobile_phone_number` unique(`MOBILE_PHONE_NUMBER`),
  index `idx_sys_user_status` (`STATUS`)
) charset=utf8 ENGINE=InnoDB;;
alter table `SYS_USER` auto_increment=1000;;


create table `SYS_ORGANIZATION`(
  `ID`         bigint not null auto_increment,
  `NAME`      varchar(100),
  `TYPE`      varchar(20),
  `PARENT_ID` bigint,
  `PARENT_IDS`  varchar(200) default '',
  `ICON`       varchar(200),
  `WEIGHT`    int,
  `IS_SHOW`       bool,
  constraint `pk_sys_organization` primary key(`ID`),
  index `idx_sys_organization_name` (`NAME`),
  index `idx_sys_organization_type` (`TYPE`),
  index `idx_sys_organization_parent_id` (`PARENT_ID`),
  index `idx_sys_organization_parent_ids_weight` (`PARENT_IDS`, `WEIGHT`)
) charset=utf8 ENGINE=InnoDB;;
alter table `sys_organization` auto_increment=1000;;


create table `SYS_JOB`(
  `ID`         bigint not null auto_increment,
  `NAME`      varchar(100),
  `PARENT_ID` bigint,
  `PARENT_IDS`  varchar(200) default '',
  `ICON`       varchar(200),
  `WEIGHT`    int,
  `IS_SHOW`       bool,
  constraint `pk_sys_job` primary key(`ID`),
  index `idx_sys_job_nam` (`NAME`),
  index `idx_sys_job_parent_id` (`PARENT_ID`),
  index `idx_sys_job_parent_ids_weight` (`PARENT_IDS`, `WEIGHT`)
) charset=utf8 ENGINE=InnoDB;;
alter table `sys_job` auto_increment=1000;;


create table `SYS_USER_ORGANIZATION_JOB`(
  `ID`         bigint not null auto_increment,
  `USER_ID`   bigint,
  `ORGANIZATION_ID` bigint,
  `JOB_ID` bigint,
  constraint `pk_sys_user_organization_job` primary key(`ID`),
  constraint `unique_sys_user_organization_job` unique(`USER_ID`, `ORGANIZATION_ID`, `JOB_ID`)
) charset=utf8 ENGINE=InnoDB;;

create table `SYS_RESOURCE`(
  `ID`         bigint not null auto_increment,
  `NAME`      varchar(100),
  `IDENTITY`  varchar(100),
  `TYPE`  varchar(100) default 'menu',
  `URL`      varchar(200),
  `PARENT_ID` bigint,
  `PARENT_IDS`  varchar(200) default '',
  `ICON`       varchar(200),
  `WEIGHT`    int,
  `IS_SHOW`       bool,
  constraint `pk_sys_resource` primary key(`ID`),
  index `idx_sys_resource_name` (`NAME`),
  index `idx_sys_resource_identity` (`IDENTITY`),
  index `idx_sys_resource_user` (`URL`),
  index `idx_sys_resource_parent_id` (`PARENT_ID`),
  index `idx_sys_resource_parent_ids_weight` (`PARENT_IDS`, `WEIGHT`)
) charset=utf8 ENGINE=InnoDB;;
alter table `sys_resource` auto_increment=1000;;


create table `SYS_PERMISSION`(
  `ID`         bigint not null auto_increment,
  `NAME`      varchar(100),
  `PERMISSION`  varchar(100),
  `DESCRIPTION`      varchar(200),
  `IS_SHOW`       bool,
  constraint `pk_sys_permission` primary key(`ID`),
  index idx_sys_permission_name (`NAME`),
  index idx_sys_permission_permission (`PERMISSION`),
  index idx_sys_permission_show (`IS_SHOW`)
) charset=utf8 ENGINE=InnoDB;;
alter table `sys_permission` auto_increment=1000;;

create table `SYS_ROLE`(
  `ID`         bigint not null auto_increment,
  `NAME`      varchar(100),
  `ROLE`  varchar(100),
  `DESCRIPTION`      varchar(200),
  `IS_SHOW`       bool,
  constraint `pk_sys_role` primary key(`ID`),
  index `idx_sys_role_name` (`NAME`),
  index `idx_sys_role_role` (`ROLE`),
  index `idx_sys_role_show` (`IS_SHOW`)
) charset=utf8 ENGINE=InnoDB;;
alter table `sys_role` auto_increment=1000;;


create table `SYS_ROLE_RESOURCE_PERMISSION`(
  `ID`         bigint not null auto_increment,
  `ROLE_ID`   bigint,
  `RESOURCE_ID` bigint,
  `PERMISSION_IDS` varchar(500),
  constraint `pk_sys_role_resource_permission` primary key(`ID`),
  constraint `unique_sys_role_resource_permission` unique(`ROLE_ID`, `RESOURCE_ID`)
) charset=utf8 ENGINE=InnoDB;;
alter table `sys_role_resource_permission` auto_increment=1000;;

create table `SYS_GROUP`(
  `ID`         bigint not null auto_increment,
  `NAME`       varchar(100),
  `TYPE`       varchar(50),
  `IS_SHOW`       bool,
  `DEFAULT_GROUP` bool,
  constraint `pk_sys_group` primary key(`ID`),
  index `idx_sys_group_type` (`TYPE`),
  index `idx_sys_group_show` (`IS_SHOW`),
  index `idx_sys_group_default_group` (`DEFAULT_GROUP`)
) charset=utf8 ENGINE=InnoDB;;


create table `SYS_AUTH`(
  `ID`         bigint not null auto_increment,
  `ORGANIZATION_ID`       bigint,
  `JOB_ID`       bigint,
  `USER_ID`        bigint,
  `GROUP_ID`       bigint,
  `ROLE_IDS`       varchar(500),
  `TYPE`           varchar(50),
  constraint `pk_sys_auth` primary key(`ID`),
  index `idx_sys_auth_organization` (`ORGANIZATION_ID`),
  index `idx_sys_auth_job` (`JOB_ID`),
  index `idx_sys_auth_user` (`USER_ID`),
  index `idx_sys_auth_group` (`GROUP_ID`),
  index `idx_sys_auth_type` (`TYPE`)
) charset=utf8 ENGINE=InnoDB;;
alter table `sys_auth` auto_increment=1000;;

