from django.urls import path
from .views import *

urlpatterns = [
    
    path('', home, name="home"),
    path('prueba/', prueba, name='prueba'),
    path('contacto/', contacto, name="contacto"),
    path('login/', login, name="login"),
    path('departamento/', departamento, name="departamento"),
    path('Reservar/', Reservar, name="Reservar"),
    path('Reservas/', Reservas, name="Reservas"),
    
]