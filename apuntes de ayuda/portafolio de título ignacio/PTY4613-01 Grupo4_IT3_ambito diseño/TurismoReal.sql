--------------------------------------------------------------------------
--------------------PROCEDIMIENTOS CRUD EDIFICIO--------------------------
--------------------------------------------------------------------------
CREATE SEQUENCE SQ_EDIFICIO;
---AGREGAR EDIFICIO
CREATE OR REPLACE PROCEDURE SP_AGREGAR_EDIFICIO 
(P_NOMBRE edificio.nombre%TYPE ,
P_DIRECCION edificio.direccion%type ,
P_CIUDAD_ID_CIUDAD edificio.ciudad_id_ciudad%TYPE)
AS
BEGIN
    INSERT INTO EDIFICIO VALUES(SQ_EDIFICIO.NEXTVAL,
                               p_nombre,
                               p_direccion,
                               p_ciudad_id_ciudad);
EXCEPTION 
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR AL AGREGAR');                              
END;
-----------MODIFICAR EDIFICIOS------------------------------------------
CREATE OR REPLACE PROCEDURE SP_MODIFICAR_EDIFICIO
(P_ID_EDIFICIO edificio.id_edificio%TYPE ,
P_NOMBRE edificio.nombre%TYPE ,
P_DIRECCION edificio.direccion%type ,
P_CIUDAD_ID_CIUDAD edificio.ciudad_id_ciudad%TYPE)
AS
BEGIN
   UPDATE EDIFICIO SET
   nombre = P_NOMBRE,
   direccion = P_DIRECCION,
   ciudad_id_ciudad = P_CIUDAD_ID_CIUDAD
   WHERE id_edificio = P_ID_EDIFICIO;
   COMMIT;
   EXCEPTION
    WHEN OTHERS THEN 
    ROLLBACK;
END ;
------------LISTAR EDIFICIOS--------------------------------------------
CREATE OR REPLACE PROCEDURE SP_LISTAR_EDIFICIO(p_lista out SYS_REFCURSOR)
IS
BEGIN
    open p_lista for select * from EDIFICIO;
END;
-----------ELIMINAR EDIFICIOS------------------------
CREATE OR REPLACE PROCEDURE SP_ELIMINAR_EDIFICIO
(P_ID_EDIFICIO edificio.id_edificio%TYPE ,
P_NOMBRE edificio.nombre%TYPE ,
P_DIRECCION edificio.direccion%type ,
P_CIUDAD_ID_CIUDAD edificio.ciudad_id_ciudad%TYPE)
AS
BEGIN
   DELETE FROM EDIFICIO
   WHERE id_edificio = P_ID_EDIFICIO;
   COMMIT;
   EXCEPTION
    WHEN OTHERS THEN 
    ROLLBACK;
END ;

-----------------------------------------------------------------------------
--------------------PROCEDIMIENTOS CRUD DEPARTAMENTO-------------------------
-----------------------------------------------------------------------------
CREATE SEQUENCE SQ_DEPARTAMENTO;
---AGREGAR DEPARTAMENTO
CREATE OR REPLACE PROCEDURE SP_AGREGAR_DEPARTAMENTO 
(P_DEPARTAMENTO departamentos.departamento%TYPE ,
P_N_DEPARTAMENTO departamentos.n_departamento%TYPE,
P_VALOR departamentos.valor%TYPE,
P_ESTADO departamentos.estado%TYPE,
P_EDIFICIO_ID_EDIFICIO departamentos.edificio_id_edificio%TYPE)
AS
BEGIN
    INSERT INTO departamentos VALUES(SQ_DEPARTAMENTO.NEXTVAL,
                              P_DEPARTAMENTO,
                               P_N_DEPARTAMENTO,
                               P_VALOR,
                               P_ESTADO,
                               P_EDIFICIO_ID_EDIFICIO);
EXCEPTION 
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR AL AGREGAR');                              
END;
-----------MODIFICAR DEPARTAMENTO------------------------------------------
CREATE OR REPLACE PROCEDURE SP_MODIFICAR_DEPARTAMENTO
(P_ID_DEPARTAMENTO departamentos.id_departamento%TYPE,
P_DEPARTAMENTO departamentos.departamento%TYPE ,
P_N_DEPARTAMENTO departamentos.n_departamento%TYPE,
P_VALOR departamentos.valor%TYPE,
P_ESTADO departamentos.estado%TYPE,
P_EDIFICIO_ID_EDIFICIO departamentos.edificio_id_edificio%TYPE)
AS
BEGIN
   UPDATE departamentos SET
    departamento = P_DEPARTAMENTO,
    n_departamento = P_N_DEPARTAMENTO,
    valor = P_VALOR,
    estado = P_ESTADO,
    edificio_id_edificio = P_EDIFICIO_ID_EDIFICIO
   WHERE id_departamento = P_ID_DEPARTAMENTO;
   COMMIT;
   EXCEPTION
    WHEN OTHERS THEN 
    ROLLBACK;
END ;
------------LISTAR DEPARTAMENTO--------------------------------------------
CREATE OR REPLACE PROCEDURE SP_LISTAR_DEPARTAMENTO(p_lista out SYS_REFCURSOR)
IS
BEGIN
    open p_lista for select * from EDIFICIO;
END;
-----------ELIMINAR DEPARTAMENTO------------------------
CREATE OR REPLACE PROCEDURE SP_ELIMINAR_EDIFICIO
(P_ID_DEPARTAMENTO departamentos.id_departamento%TYPE,
P_DEPARTAMENTO departamentos.departamento%TYPE ,
P_N_DEPARTAMENTO departamentos.n_departamento%TYPE,
P_VALOR departamentos.valor%TYPE,
P_ESTADO departamentos.estado%TYPE,
P_EDIFICIO_ID_EDIFICIO departamentos.edificio_id_edificio%TYPE)
AS
BEGIN
   DELETE FROM DEPARTAMENTOS
   WHERE id_departamento = P_ID_DEPARTAMENTO;
   COMMIT;
   EXCEPTION
    WHEN OTHERS THEN 
    ROLLBACK;
END ;

-----------------------------------------------------------------------------
--------------------PROCEDIMIENTOS CRUD SERVICIOS ---------------------------
-----------------------------------------------------------------------------
CREATE SEQUENCE SQ_SERVICIO;
---AGREGAR SERVICIO
CREATE OR REPLACE PROCEDURE SP_AGREGAR_SERVICIO 
(P_ID_RESERVAS servicios.id_reservas%TYPE,
P_NOMBRE servicios.nombre%TYPE,
P_TIPO_SERVICIO servicios.tipo_servicio%TYPE,
P_HORARIO servicios.horario%TYPE,
P_VALOR servicios.valor%TYPE,
P_RESERVA_ID_RESERVA servicios.reservas_id_reserva%TYPE,
P_DESCRIPCION servicios.descripcion%TYPE,
P_MULTA servicios.multa%TYPE,
P_DESCRIPCION_MULTA servicios.descripcion_multa%TYPE)
AS
BEGIN
    INSERT INTO servicios VALUES(SQ_DEPARTAMENTO.NEXTVAL,
                              P_ID_RESERVAS,
                               P_NOMBRE,
                               P_TIPO_SERVICIO,
                               P_HORARIO,
                               P_VALOR,
                               P_RESERVA_ID_RESERVA,
                               P_DESCRIPCION,
                               P_MULTA,
                               P_DESCRIPCION_MULTA);
EXCEPTION 
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR AL AGREGAR');                              
END;
-----------MODIFICAR SERVICIO---------------------------------------------------
CREATE OR REPLACE PROCEDURE SP_MODIFICAR_SERVICIO
(P_ID_SERVICIOS servicios.id_servicios%TYPE,
P_ID_RESERVAS servicios.id_reservas%TYPE,
P_NOMBRE servicios.nombre%TYPE,
P_TIPO_SERVICIO servicios.tipo_servicio%TYPE,
P_HORARIO servicios.horario%TYPE,
P_VALOR servicios.valor%TYPE,
P_RESERVA_ID_RESERVA servicios.reservas_id_reserva%TYPE,
P_DESCRIPCION servicios.descripcion%TYPE,
P_MULTA servicios.multa%TYPE,
P_DESCRIPCION_MULTA servicios.descripcion_multa%TYPE)
AS
BEGIN
   UPDATE servicios SET
    id_reservas = P_ID_RESERVAS,
    nombre = P_NOMBRE,
    tipo_servicio = P_TIPO_SERVICIO,
    horario = P_HORARIO,
    valor = P_VALOR,
    reservas_id_reserva = P_RESERVA_ID_RESERVA,
    descripcion = P_DESCRIPCION,
    multa = P_MULTA,
    descripcion_multa = P_DESCRIPCION_MULTA
   WHERE id_servicios = P_ID_SERVICIOS;
   COMMIT;
   EXCEPTION
    WHEN OTHERS THEN 
    ROLLBACK;
END ;
------------LISTAR SERVICIO--------------------------------------------
CREATE OR REPLACE PROCEDURE SP_LISTAR_SERVICIO(p_lista out SYS_REFCURSOR)
IS
BEGIN
    open p_lista for select * from SERVICIOS;
END;
-----------ELIMINAR SERVICIO------------------------
CREATE OR REPLACE PROCEDURE SP_ELIMINAR_SERVICIO
(P_ID_SERVICIOS servicios.id_servicios%TYPE,
P_ID_RESERVAS servicios.id_reservas%TYPE,
P_NOMBRE servicios.nombre%TYPE,
P_TIPO_SERVICIO servicios.tipo_servicio%TYPE,
P_HORARIO servicios.horario%TYPE,
P_VALOR servicios.valor%TYPE,
P_RESERVA_ID_RESERVA servicios.reservas_id_reserva%TYPE,
P_DESCRIPCION servicios.descripcion%TYPE,
P_MULTA servicios.multa%TYPE,
P_DESCRIPCION_MULTA servicios.descripcion_multa%TYPE)
AS
BEGIN
   DELETE FROM SERVICIOS
   WHERE id_servicios = P_ID_SERVICIOS;
   COMMIT;
   EXCEPTION
    WHEN OTHERS THEN 
    ROLLBACK;
END ;

