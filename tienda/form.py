from django import forms

class Registroform(forms.Form):
    nombre = forms.CharField(label='Usuario')
    password1 = forms.CharField(widget=forms.PasswordInput,label='Contraseña')
    password2 = forms.CharField(widget=forms.PasswordInput,label='Confirmar Contraseña')


class Productform(forms.Form):
    name = forms.CharField(label='Nombre',max_length=200)
    amount = forms.FloatField(label='Cantidad')
    buy_price = forms.FloatField(label='Precio compra')
    sell_price = forms.FloatField(label='Precio venta')
    

