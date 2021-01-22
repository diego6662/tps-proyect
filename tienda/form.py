from django import forms

class Registroform(forms.Form):
    nombre = forms.CharField(label='Usuario')
    password1 = forms.CharField(widget=forms.PasswordInput,label='Contraseña')
    password2 = forms.CharField(widget=forms.PasswordInput,label='Confirmar Contraseña')
