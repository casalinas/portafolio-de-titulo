from django.http.request import HttpRequest
from django.http.response import HttpResponseRedirect
from django.shortcuts import render
from django.template import RequestContext
from django.db import connection
import cx_Oracle
from django.contrib import messages
from .models import Usuarios, UsuariosContrasenas

# Create your views here.

def home(request):
    return render(request, 'Turismo/home.html')

def contacto(request):
    
    return render(request, 'Turismo/contacto.html')

def departamento(request):
    return render(request, 'Turismo/departamento.html')

def login(request):
    '''if request.method =='POST':
        formulario = formLog(request.POST)
        if formulario.is_valid:
            usuario = request.POST('usuario')
            contrasena = request.POST('contrasena')
            verificacion = UsuariosContrasenas.objects.filter(usuario=usuario, contrasena=contrasena).exists()

            if verificacion == True:
                return HttpResponseRedirect('Turismo/home.html')
            else:
                return HttpResponseRedirect('Turismo/Prueba.html')

    else: 
        formulario = formLog()
'''
    '''if request.method == 'POST':
        
        nombre= request.POST.get('nombre')
        appat = request.POST.get('appat')
        apmat = request.POST.get('apmat')
        rut = request.POST.get('rut')
        email = request.POST.get('email')
        direccion = request.POST.get('direccion')
        telefono = request.POST.get('telefono')
        contrasena = request.POST.get('contrasena')
        salida = crear_usuarios(nombre, rut, appat, apmat,telefono, email, contrasena)
        #if salida ==0:
         #   data['mensaje'] = 'Usuario agregado'
        #else:
         #   data['mensaje'] = 'No se ha podido guardar'''
        
    return render(request, 'Turismo/login.html')

def Reservar(request):
    return render(request, 'Turismo/Reservar.html')

def Reservas(request):
    return render(request, 'Turismo/Reservas.html')

def prueba(request):
    data = {
        'Usuarios':listado_usuarios()
    }
    
    crear_usuarios('Sandra','0000000000-0','martinez','ascencio','942075696','bastian@gmail.com','123',)
    
    return render(request, 'Turismo/Prueba.html', data)


#CRUD USUARIOS
def listado_usuarios():
    django_cursor = connection.cursor()
    cursor = django_cursor.connection.cursor()
    out_cur = django_cursor.connection.cursor()

    cursor.callproc("SP_LISTAR_USUARIO", [out_cur])

    lista = []
    for fila in out_cur:
        lista.append(fila)

    return lista

def crear_usuarios(nombre, rut, appat, apmat,telefono, email, contrasena, salida):
    django_cursor = connection.cursor()
    cursor = django_cursor.connection.cursor()
    salida = cursor.var(cx_Oracle.NUMBER)
    cursor.callproc('SP_CREAR_USUARIO', [nombre, rut, appat, apmat, telefono, email, contrasena, salida])
    return salida.getvalue()

def eliminar_usuario(rut):
    django_cursor = connection.cursor()
    cursor = django_cursor.connection.cursor()
    out_cur = django_cursor.connection.cursor()

    cursor.callproc('SP_ELIMINAR_USUARIO', [rut])


def validar_usuarios(rut, contrasena):
    django_cursor = connection.cursor()
    cursor = django_cursor.connection.cursor()
    salida = cursor.var(cx_Oracle.NUMBER)
    cursor.callproc('SP_VALIDAR_USUARIO', [rut, contrasena, salida])
    return salida.getvalue()