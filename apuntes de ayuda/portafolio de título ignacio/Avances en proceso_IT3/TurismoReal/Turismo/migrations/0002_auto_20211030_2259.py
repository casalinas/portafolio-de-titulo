# Generated by Django 3.2.7 on 2021-10-31 01:59

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('Turismo', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Acompanantes',
            fields=[
                ('id_acompanante', models.BigIntegerField(primary_key=True, serialize=False)),
                ('nombre', models.CharField(max_length=50)),
                ('rut', models.CharField(max_length=15)),
            ],
            options={
                'db_table': 'acompanantes',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='UsuariosContrasenas',
            fields=[
                ('id_pass', models.BigIntegerField(primary_key=True, serialize=False)),
                ('contrasena', models.CharField(max_length=50)),
                ('usuario', models.CharField(max_length=25)),
                ('activo', models.CharField(max_length=2)),
                ('fecha_actualizacion', models.DateField()),
            ],
            options={
                'db_table': 'usuarios_contrasenas',
                'managed': False,
            },
        ),
        migrations.DeleteModel(
            name='Acompaniantes',
        ),
        migrations.DeleteModel(
            name='UsuariosContrasenias',
        ),
    ]
