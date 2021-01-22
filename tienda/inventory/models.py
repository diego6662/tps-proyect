from django.db import models

# Create your models here.
class Producto(models.Model):
    nombre = models.CharField(max_length=200)
    cantidad_actual = models.FloatField()
    precio_venta = models.FloatField()
    costo_promedio = models.FloatField(blank=True)#esto es igual al precio de compra
                                                  #promediado de todos los productos
    id_categoria = models.IntegerField()
    precio_compra = models.FloatField()
