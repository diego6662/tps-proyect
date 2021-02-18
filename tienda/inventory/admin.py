from django.contrib import admin
from .models import Producto,Categoria
# Register your models here.
class permisos(admin.ModelAdmin):
    readonly_fields = ['id']
admin.site.register(Producto,permisos)
admin.site.register(Categoria,permisos)
