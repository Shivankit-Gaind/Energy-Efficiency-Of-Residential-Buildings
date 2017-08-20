from django.shortcuts import render
from django.http import HttpResponse
from .apg import fn
def index(request):
    return HttpResponse("Arka rocks")
def fun(request,p1,p2,p3,p4,p5,p6,p7,p8):
	p1 = int(p1)
	p2 = int(p2)
	p3 = int(p3)
	p4 = int(p4)
	p5 = int(p5)
	p6 = int(p6)
	p7 = int(p7)
	p8 = int(p8)
	return HttpResponse(fn(p1,p2,p3,p4,p5,p6,p7,p8))
