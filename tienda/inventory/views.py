from django.shortcuts import render,get_object_or_404
from .models import Producto
# Create your views here.
def index(request):
    productos = Producto.objects.all()
    return render(request,'inventory/index.html',{'productos':productos})
