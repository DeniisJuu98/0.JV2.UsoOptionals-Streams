package Ejercicio1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercio1 {


    public static void main(String[] args) throws IOException {
        //Creamos un array para ir poder almacenar Persona
        ArrayList <Persona> lista = new ArrayList<Persona>();

        try{
            //Creacion de ficheros
            File fic = new File("C:\\Users\\denis.prodisteanu\\IdeaProjects\\untitled\\src\\Ejercicio1\\Datos.txt.txt");
            BufferedReader fichero = new BufferedReader(new FileReader(fic));

            //Lectura de ficheros, se acabara la lectura cuando devuelva null
            String linea;
            while((linea = fichero.readLine())!=null){
                //vamos introduciendo en el array la persona leida del fichero
                //usamos un metodo externo para ello "textoAPersona"
                lista.add(textoAPersona(linea));
            }

            //Creamos un nuevo array donde introduciremos la filtracion de las edades < 25
            ArrayList lista2 = (ArrayList) lista.stream()
                     //Al estar la edad en String, se usara el parseInt para pasar a int
                    .filter(persona -> (Integer.parseInt(persona.getEdad()) < 25))
                    .filter(persona -> (Integer.parseInt(persona.getEdad()) != 0))
                     //Convertimos a colecciones
                    .collect(Collectors.toList());

            int e = 1;
            //usamos este bucle para mostrar de manera bonita, los datos obtenidos
            for (int i = 0 ; i<lista2.size();i++){
                System.out.println("Línea "+ e + "." + lista2.get(i));
                e++;
            }
            //System.out.println(lista2.toString());
            //cerramos el fichero de lectura
            fichero.close();
        }
        catch (FileNotFoundException fn ){
            System.out.println("No se encuentra el fichero");}
        catch (IOException io) {
            System.out.println("Error de E/S ");}
    }

    public static Persona textoAPersona(String cadena) {
        //Creanis un nuevo objeto Persona
        Persona p = new Persona();

        //Separamos la cedena obtenida con tokens ":"
        String[] tokens = cadena.split(":");

        //modificamos la clase persona,e introducimos 
        //los tokens correspondientes en cada dato de la persona
        if (tokens[0].equals("")) {
            p.setNombre("Desconocida");
        } else {
            p.setNombre(tokens[0]);
        }

        if (tokens[1].equals("")) {
            p.setPoblacion("Desconocida");
        } else {
            p.setPoblacion(tokens[1]);
        }

        //En el caso de que uno de los campos esta vacio
        //se filtra
        if (!(tokens.length < 3)){
            if (tokens[2].equals("")) {
                //como es un string, para poder luego usar el parseInt 
                //se pondra a 0 ya que si no, dara error
                p.setEdad("0");
            } else {
                p.setEdad(tokens[2]);
            }
        }else {
            //como es un string, para poder luego usar el parseInt 
            //se pondra a 0 ya que si no, dara error
            p.setEdad("0");
        }
        //devolvemos la persona
        return p;
    }


}
