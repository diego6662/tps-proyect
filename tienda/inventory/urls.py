from django.urls import path
from . import views
app_name = 'inventory'
urlpatterns = [
    path('',views.index,name='index'),
    path('signup',views.sign_up_user,name='signupuser'),
    path('product-register', views.create_products, name='createProduct'),
    path('<int:id>', views.change_product, name='change'),
    path('<int:id>/agregar', views.add_product, name='add')
]
