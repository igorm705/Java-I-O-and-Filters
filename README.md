Java I/O and Filters 
Excercise #1. Grade 86.00 / 100.00

In this exercise I've defined an interface "WebPageFilter" for the filtering of HTML documents and implemented filters:

EnglishDocumentsFilter - a filter that accepts only documents that seems to be written in English.
RejectJavaScriptFilter - a filter that doesn't allow pages that contain JavaScript sources in them.
In addition I've implemented "RestrictedView" - a small application that let the user view the content of web pages, but restrict 
the access to some pages (as defined before).

There is also HTMLTagRemover.java for the exclusion of HTML tags from a given document.

Exceptions: my general goal is that my program should never crash with uncaught exceptions. The other important aspect is to catch 
exceptions at the correct scope.

Design notes: for the implementation of RestrictedView I've created WebPageFilter objects according to given keywords 
(for example I create a GamingFilter object I do it with respect to the user request of the -gaming flag). The preferred way to do this 
is to write a class called WebPageFilterFactory that has a method (signature below) that receives a name of a filter and return 
a suitable WebPageFilter object (Abstract factory).
