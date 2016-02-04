

mvn cobertura:cobertura

target/site/cobertura/



II. 

Aplicar patrón comando:

![aa](img/BaseModel.png)

Teniendo en cuenta el API de JTextArea

https://docs.oracle.com/javase/7/docs/api/javax/swing/JTextArea.html

* insert
* replaceRange
* getCaretPosition
* getSelectedText


        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(">>>>"+e);                
                
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

Especificaciones:

- Escritura convencional: se pueden deshacer los últimos 5 caracteres escritos.
- Se debe poder deshacer la eliminación mediante la tecla 'backspace'
- Tener en cuenta que al momento de deshacer, el cursor (caret) puede estar en una posición difernete a la que se realizó la operación.
- Si se oprime el back-space después de tener un área seleccionada, el 'deshacer' de esta acción debería recuperar todo el texto escrito.



Haga la especificación 



ComandoX
------------
execute()






