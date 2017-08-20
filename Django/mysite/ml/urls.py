from django.conf.urls import url

from . import views

urlpatterns = [
    url(r'^(?P<p1>[0-9]+)/(?P<p2>[0-9]+)/(?P<p3>[0-9]+)/(?P<p4>[0-9]+)/(?P<p5>[0-9]+)/(?P<p6>[0-9]+)/(?P<p7>[0-9]+)/(?P<p8>[0-9]+)/$', views.fun, name='fun'),
    url(r'^$', views.index, name='index'),
]

