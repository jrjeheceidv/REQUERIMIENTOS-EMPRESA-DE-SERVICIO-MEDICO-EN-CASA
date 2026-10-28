
        
        // Variable de control para el ciclo continuo tipo while
        String Continuar = "Si";

        // Ciclo repetitivo para permitir registrar diferentes usuarios
        while (true) {
            
            // Menú de opciones de la aplicación
            System.out.println("=================================================");
            System.out.println("        EMPRESA DE SERVICIO MEDICO EN CASA       ");
            System.out.println("=================================================");
            System.out.println("1. Registrar Cliente ");
            System.out.println("2. Tipo de plan ");
            System.out.println("3. Otros usuarios ");
            System.out.println("4. Valor mensual");
            System.out.println("5. Respaldo TXT");
            System.out.println("6. Descuento ");
            System.out.println("7. Visualizar informacion");
            System.out.println("8. Salir");
            System.out.println("=================================================");
            System.out.println("USUARIO SELECCIONE UNA OPCION (1-8): ");
            opcion = teclado.nextInt();
            teclado.nextLine(); 

           

            //crear el Switch case varias veces
            switch (opcion){

                case 1:
                    System.out.println("INGRESE EL NOMBRE DEL CLIENTE:");
                    nombre = teclado.nextLine();

                
                System.out.println("INGRESE LA CEDULA DEL CLIENTE:");
                cedula = teclado.nextLine();

                System.out.println("INGRESE LOS SINTOMAS DEL CLIENTE:");
                sintomas = teclado.nextLine();

                System.out.println("INGRESE LA DIRECCION DE RESIDENCIA:");
                direccion = teclado.nextLine();
                
                System.out.println("¡Datos del cliente registrados con exito!\n");
            
                //Si el médico escribe la palabra medicamento se termina esa factura
                if (nombre.equalsIgnoreCase("medicamento")) {
                    System.out.println("PALABRA CLAVE DETECTADA: Se finaliza la factura actual.");
                    break;
                }
                
                break;
            case 2:
                System.out.println("INGRESE EL TIPO DE PLAN (Usar las siglas PB o PP):");
                tipoPlan = teclado.nextLine();

                if (tipoPlan.equalsIgnoreCase("PB")) {
                    costoPlan = 275325; // Plan básico con costo 275,325 COP
                    System.out.println("Plan Básico seleccionado (Costo: " + formatoPesos.format(costoPlan) + ")");
                } else if (tipoPlan.equalsIgnoreCase("PP")) {
                    costoPlan = 325650; // Plan premium con costo 325,650 COP
                    System.out.println("Plan Premium seleccionado (Costo: " + formatoPesos.format(costoPlan) + ")");
                } else {
                    System.out.println("Sigla no valida. Se asignara por defecto Plan Basico (PB).");
                    costoPlan = 275325;
                    tipoPlan = "PB";
                }
            break;

            
            case 3:
                System.out.println("INGRESE LA CANTIDAD DE OTROS USUARIOS (Debe ser un numero entero):");
                otrosUsuarios = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Cantidad de usuarios registrada con exito.");
                break;

            case 4:
                if (otrosUsuarios == 0) {
                    otrosUsuarios = 1; // Valor por defecto si no se ingresa
                }
                valorMensual = costoPlan * otrosUsuarios;
                System.out.println("El valor mensual calculado es: " + formatoPesos.format(valorMensual));
                break;

        
            case 6:
                // Si el síntoma es gripa o alergia aplicar un descuento en ambos planes del 12.5%
                if (sintomas.equalsIgnoreCase("gripa") || sintomas.equalsIgnoreCase("alergia")) {
                    descuento = valorMensual * 0.125;
                    System.out.println("Se aplico el descuento del 12.5% por sintomas de gripa o alergia.");
                } else {
                    descuento = 0;
                    System.out.println("No aplica descuento para los sintomas ingresados.");
                }
                valorFinal = valorMensual - descuento;
                break;

            case 7:
                valorFinal = valorMensual - descuento;
                System.out.println("=================================================");
                System.out.println("              INFORMACION REGISTRADA             ");
                System.out.println("=================================================");
                System.out.println("Nombre del cliente: " + nombre);
                System.out.println("Cedula: " + cedula);
                System.out.println("Direccion de residencia: " + direccion);
                System.out.println("Sintomas: " + sintomas);
                System.out.println("Tipo de plan: " + tipoPlan);
                System.out.println("Cantidad de otros usuarios: " + otrosUsuarios);
                System.out.println("Valor mensual: " + formatoPesos.format(valorMensual));
                System.out.println("Descuento aplicado: " + formatoPesos.format(descuento));
                System.out.println("Valor final a pagar: " + formatoPesos.format(valorFinal));
                System.out.println("=================================================\n");
            break;

            case 5:
                valorFinal = valorMensual - descuento;
                LocalDate tiempo = LocalDate.now();
                LocalTime hora = LocalTime.now();

                try {
                    FileWriter fw = new FileWriter("C:\\Users\\santi\\OneDrive\\Desktop\\archivo.txt");
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("=====================================\n");
                    bw.write("       SERVICIO MEDICO EN CASA       \n");
                    bw.write("=====================================\n");
                    bw.write("Fecha del registro: " + tiempo + "\n");
                    bw.write("Hora del registro: " + hora + "\n");
                    bw.write("Nombre: " + nombre + "\n");
                    bw.write("Cedula: " + cedula + "\n");
                    bw.write("Sintomas: " + sintomas + "\n");
                    bw.write("Direccion: " + direccion + "\n");
                    bw.write("Tipo de plan: " + tipoPlan + "\n");
                    bw.write("Otros usuarios: " + otrosUsuarios + "\n");
                    bw.write("Valor mensual: " + formatoPesos.format(valorMensual) + "\n");
                    bw.write("Descuento: " + formatoPesos.format(descuento) + "\n");
                    bw.write("Valor a pagar: " + formatoPesos.format(valorFinal) + "\n");
                    bw.write("=====================================\n");
                    bw.close();
                    fw.close();
                    System.out.println("¡Respaldo en TXT generado con exito en el escritorio!");
                } catch (IOException error) {
                    System.out.println("ALERTA VERIFIQUE RESPALDO " + error.getMessage());
                }
                break;
            
            case 8:
                System.out.println("¿DESEA REALIZAR OTRO REGISTRO? (Si / No):");
                Continuar = teclado.next();
                teclado.nextLine(); 
            
        }
            break;
            }
        // Mensaje final del programa
        System.out.println("GRACIAS POR USAR EL SISTEMA DE SERVICIO MEDICO EN CASA.");
        teclado.close();
    }
}
