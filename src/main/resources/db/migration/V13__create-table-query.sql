create table query
(
    id         bigint   not null auto_increment,
    medical_id bigint   not null,
    nurse_id   bigint   not null,
    patient_id bigint   not null,
    date       datetime not null,


    primary key (id),
    constraint fk_query_medical_id foreign key (medical_id) references medicals (id),
    constraint fk_query_nurse_id foreign key (nurse_id) references nurses (id),
    constraint fk_query_patient_id foreign key (patient_id) references patients (id)

);