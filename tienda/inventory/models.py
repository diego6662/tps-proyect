from django.db import models

# Create your models here.
class Categoria(models.Model):
    
    nombre_categoria = models.CharField(max_length=200)
    
    def __str__(self):
        return self.nombre_categoria

class Producto(models.Model):
    nombre = models.CharField(max_length=200)
    cantidad_actual = models.FloatField()
    precio_venta = models.FloatField()
    costo_promedio = models.FloatField(blank=True,null=True)#esto es igual al precio de compra
                                                  #promediado de todos los productos
    id_categoria = models.ForeignKey(Categoria, on_delete = models.CASCADE, blank=True, null=True)
    precio_compra = models.FloatField()
    
    def __str__(self):
        return self.nombre 
