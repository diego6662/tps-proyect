from django.shortcuts import render,get_object_or_404,redirect
from .models import Producto, Categoria
from form import Registroform, Productform
from django.contrib.auth.models import User
from django.db import IntegrityError
from django.contrib.auth import login
# Create your views here.
def index(request):
    productos = Producto.objects.all()
    return render(request,'inventory/index.html',{'productos':productos})

def sign_up_user(request):
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

def create_products(request):
    form = Productform()
    if request.method == 'GET':
        categorias = Categoria.objects.all()
        return render(request,'inventory/registroProducto.html',{'form':form,'categorias':categorias})
    else:
        try:
            category = Categoria.objects.get(pk=int(request.POST['Category']))     
            product = Producto(nombre=request.POST['name'],cantidad_actual=float(request.POST['amount']),precio_venta=float(request.POST['sell_price']),id_categoria=category,precio_compra=float(request.POST['buy_price']),costo_promedio=float(request.POST['buy_price']))
            product.save()
            return redirect('/')
        except :
            return render(request,'inventory/registroProducto.html',{'form':form,'error':'Hubo un error'})

def change_product(request,id):
    product = get_object_or_404(Producto,id=id)
    context = {
            'producto':product
            }
    return render(request,'inventory/change.html',context)

def add_product(request,id):
    product = Producto.objects.get(pk=id)
    context = {'producto':product}
    if request.method == 'GET':
        return render(request,'inventory/addProduct.html',context)
    else:
        cantidad = product.cantidad_actual
        precio_promedio = product.costo_promedio
        new_cost = float(request.POST['precio'])
        new_amount = float(request.POST['cantidad'])
        promedio_actual = precio_promedio * cantidad
        promedio_user = new_cost * new_amount
        total = cantidad + new_amount
        new_mean = (promedio_actual + promedio_user) / total
        product.cantidad_actual = total
        product.costo_promedio = new_mean
        product.save()
        return redirect('/')
