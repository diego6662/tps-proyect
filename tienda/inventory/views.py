from django.shortcuts import render,get_object_or_404,redirect
from .models import Producto
from form import Registroform
from django.contrib.auth.models import User
from django.db import IntegrityError
from django.contrib.auth import login
# Create your views here.
def index(request):
    productos = Producto.objects.all()
    return render(request,'inventory/index.html',{'productos':productos})

def signupuser(request):
    if request.method == 'GET':
        return render(request,'inventory/signup.html',{'form':Registroform()})
    else:
        if request.POST['password1'] == request.POST['password2']:
            try:
                user = User.objects.create_user(request.POST['nombre'],password=request.POST['password1'])
                user.save()
                login(request,user)
                return redirect('/')
            except IntegrityError:
                
                return render(request,'inventory/signup.html',{'form':Registroform(),'error':'El usuario ya existe intente otro nombre de usuario'})
                
        else:

            return render(request,'inventory/signup.html',{'form':Registroform(),'error':'Las contraseñas no coinciden'})
