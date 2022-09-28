# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey and OneToOneField has `on_delete` set to the desired behavior
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models


class Acompanantes(models.Model):
    id_acompanante = models.BigIntegerField(primary_key=True)
    nombre = models.CharField(max_length=50)
    rut = models.CharField(max_length=15)
    reservas_id_reserva = models.ForeignKey('Reservas', models.DO_NOTHING, db_column='reservas_id_reserva')

    def __str__(self):
        return self.nombre

    class Meta:
        verbose_name = "Acompanante"
        verbose_name_plural = "Acompanantes"
        managed = False
        db_table = 'acompanantes'


class Ciudad(models.Model):
    id_ciudad = models.BigIntegerField(primary_key=True)
    ciudad = models.CharField(max_length=100)
    region_id_region = models.ForeignKey('Region', models.DO_NOTHING, db_column='region_id_region')

    def __str__(self):
        return self.ciudad
    class Meta:
        verbose_name = "Ciudad"
        verbose_name_plural = "Ciudades"
        managed = False
        db_table = 'ciudad'


class Departamentos(models.Model):
    id_departamento = models.BigIntegerField(primary_key=True)
    departamento = models.CharField(max_length=50)
    n_departamento = models.CharField(max_length=100)
    valor = models.FloatField()
    estado = models.CharField(max_length=50)
    edificio_id_edificio = models.ForeignKey('Edificio', models.DO_NOTHING, db_column='edificio_id_edificio')

    def __str__(self):
        return self.departamento

    class Meta:
        verbose_name = "Departamento"
        verbose_name_plural = "Departamentos"
       
        managed = False
        db_table = 'departamentos'


class Edificio(models.Model):
    id_edificio = models.BigIntegerField(primary_key=True)
    nombre = models.CharField(max_length=255)
    direccion = models.CharField(max_length=255)
    ciudad_id_ciudad = models.ForeignKey(Ciudad, models.DO_NOTHING, db_column='ciudad_id_ciudad')

    def __str__(self):
        return self.nombre
    class Meta:
        verbose_name = "Edificio"
        verbose_name_plural = "Edificios"
       
        managed = False
        db_table = 'edificio'


class Imagenes(models.Model):
    id_imagen = models.BigIntegerField(primary_key=True)
    nombre = models.CharField(max_length=250)
    imagen = models.BinaryField()
    departamentos_id_departamento = models.ForeignKey(Departamentos, models.DO_NOTHING, db_column='departamentos_id_departamento')

    def __str__(self):
        return self.nombre
    class Meta:
        verbose_name = "Imagen"
        verbose_name_plural = "Imagenes"
       
        managed = False
        db_table = 'imagenes'
        unique_together = (('id_imagen', 'departamentos_id_departamento'),)


class Inventario(models.Model):
    id_inventario = models.BigIntegerField(primary_key=True)
    nombre = models.CharField(max_length=100)
    cantidad = models.IntegerField()
    valor = models.IntegerField()
    departamentos_id_departamento = models.ForeignKey(Departamentos, models.DO_NOTHING, db_column='departamentos_id_departamento')

    def __str__(self):
        return self.nombre
    class Meta:
        verbose_name = "Inventario"
        verbose_name_plural = "Inventario"
       
        managed = False
        db_table = 'inventario'


class Perfil(models.Model):
    id_perfil = models.FloatField(primary_key=True)
    perfil = models.CharField(max_length=50)

    def __str__(self):
        return self.perfil
    class Meta:
        verbose_name = "Inventario"
        verbose_name_plural = "Perfiles"
       
        managed = False
        db_table = 'perfil'


class Region(models.Model):
    id_region = models.BigIntegerField(primary_key=True)
    region = models.CharField(max_length=50)

    def __str__(self):
        return self.region
    class Meta:
        verbose_name = "Region"
        verbose_name_plural = "Regiones"
       
        managed = False
        db_table = 'region'


class Reservas(models.Model):
    id_reserva = models.BigIntegerField(primary_key=True)
    usuarios_id_usuario = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='usuarios_id_usuario')
    departamentos_id_departamento = models.ForeignKey(Departamentos, models.DO_NOTHING, db_column='departamentos_id_departamento')
    fecha_ida = models.DateField()
    fecha_vuelta = models.DateField()
    valor_total = models.IntegerField()
    fecha_ingreso = models.DateField()

    def __str__(self):
        return self.id_reserva
    class Meta:
        verbose_name = "Reserva"
        verbose_name_plural = "Reservas"
       
        managed = False
        db_table = 'reservas'


class ResponsableServicios(models.Model):
    id_rservicios = models.BigIntegerField(primary_key=True)
    nombre = models.CharField(max_length=100)
    vehiculo = models.CharField(max_length=100)
    ruta = models.CharField(max_length=100)
    patente = models.CharField(max_length=20)
    nombre_empresa = models.CharField(max_length=100)
    servicios_id_servicios = models.ForeignKey('Servicios', models.DO_NOTHING, db_column='servicios_id_servicios')

    def __str__(self):
        return self.nombre

    class Meta:
        verbose_name = "Responsable Servicio"
        verbose_name_plural = "Responsable Servicios"
       
        managed = False
        db_table = 'responsable_servicios'


class Servicios(models.Model):
    id_servicios = models.FloatField(primary_key=True)
    id_reservas = models.BigIntegerField()
    nombre = models.CharField(max_length=100)
    tipo_servicio = models.CharField(max_length=200)
    horario = models.CharField(max_length=100)
    valor = models.FloatField()
    reservas_id_reserva = models.ForeignKey(Reservas, models.DO_NOTHING, db_column='reservas_id_reserva')
    descripcion = models.CharField(max_length=50)
    multa = models.IntegerField(blank=True, null=True)
    descripcion_multa = models.CharField(max_length=100, blank=True, null=True)

    def __str__(self):
        return self.nombre

    class Meta:
        verbose_name = "Servicio"
        verbose_name_plural = "Servicios"
       
        
        managed = False
        db_table = 'servicios'


class Usuarios(models.Model):
    id_usuario = models.BigIntegerField(primary_key=True)
    nombre = models.CharField(max_length=50)
    rut = models.CharField(max_length=15)
    appat = models.CharField(max_length=50)
    apmat = models.CharField(max_length=50)
    fecha_ingreso = models.DateField()
    telefono = models.CharField(max_length=25)
    email = models.CharField(max_length=100)
    perfil_id_perfil = models.ForeignKey(Perfil, models.DO_NOTHING, db_column='perfil_id_perfil')

    def __str__(self):
        return self.nombre
    class Meta:
        verbose_name = "Usuario"
        verbose_name_plural = "Usuarios"
       
        
        managed = False
        db_table = 'usuarios'


class UsuariosContrasenas(models.Model):
    id_pass = models.BigIntegerField(primary_key=True)
    usuarios_id_usuario = models.ForeignKey(Usuarios, models.DO_NOTHING, db_column='usuarios_id_usuario')
    contrasena = models.CharField(max_length=50)
    usuario = models.CharField(max_length=25)
    activo = models.CharField(max_length=2)
    fecha_actualizacion = models.DateField()

    def __str__(self):
        return self.usuario
    class Meta:
        verbose_name = "Contrasena Usuario"
        verbose_name_plural = "Contrasenas Usuarios"
       
        
        managed = False
        db_table = 'usuarios_contrasenas'
