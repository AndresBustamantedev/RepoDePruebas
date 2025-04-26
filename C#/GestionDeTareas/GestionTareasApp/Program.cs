using System;
using System.Collections.Generic;
using System.IO;

namespace GestionTareas
{
    enum TipoTarea
    {
        Personal,
        Trabajo,
        Ocio
    }

    class Tarea
{
    private static int contadorId = 1;
    public int Id { get; private set; }
    public string Nombre { get; set; }
    public string Descripcion { get; set; }
    public TipoTarea Tipo { get; set; }
    public bool Prioridad { get; set; }

    public Tarea(string nombre, string descripcion, TipoTarea tipo, bool prioridad)
    {
        Id = contadorId++;
        Nombre = nombre;
        Descripcion = descripcion;
        Tipo = tipo;
        Prioridad = prioridad;
    }

    public Tarea(int id, string nombre, string descripcion, TipoTarea tipo, bool prioridad)
    {
        Id = id;
        Nombre = nombre;
        Descripcion = descripcion;
        Tipo = tipo;
        Prioridad = prioridad;

        // Asegura que el contador continúa desde el ID más alto
        if (id >= contadorId)
            contadorId = id + 1;
    }

    public override string ToString()
    {
        return $"{Id} - {Nombre} | {Descripcion} | Tipo: {Tipo} | Prioridad: {(Prioridad ? "Alta" : "Baja")}";
    }

    public string ToFileString()
    {
        return $"{Id},{Nombre},{Descripcion},{Tipo},{Prioridad}";
    }

    public static Tarea FromFileString(string linea)
    {
        var partes = linea.Split(',');
        return new Tarea(int.Parse(partes[0]), partes[1], partes[2], Enum.Parse<TipoTarea>(partes[3]), bool.Parse(partes[4]));
    }
}

    class Program
    {
        static List<Tarea> tareas = new List<Tarea>();

        static void Main(string[] args)
        {
            bool salir = false;
            while (!salir)
            {
                Console.WriteLine("\n--- GESTIÓN DE TAREAS ---");
                Console.WriteLine("1. Crear Tarea");
                Console.WriteLine("2. Buscar Tareas por Tipo");
                Console.WriteLine("3. Eliminar Tarea");
                Console.WriteLine("4. Exportar Tareas");
                Console.WriteLine("5. Importar Tareas");
                Console.WriteLine("6. Salir");
                Console.Write("Selecciona una opción: ");
                string opcion = Console.ReadLine();

                switch (opcion)
                {
                    case "1":
                        CrearTarea();
                        break;
                    case "2":
                        BuscarTareasPorTipo();
                        break;
                    case "3":
                        EliminarTarea();
                        break;
                    case "4":
                        ExportarTareas();
                        break;
                    case "5":
                        ImportarTareas();
                        break;
                    case "6":
                        salir = true;
                        break;
                    default:
                        Console.WriteLine("Opción no válida.");
                        break;
                }
            }
        }

        static void CrearTarea()
        {
            Console.Write("Nombre de la tarea: ");
            string nombre = Console.ReadLine();

            Console.Write("Descripción de la tarea: ");
            string descripcion = Console.ReadLine();

            Console.Write("Tipo de tarea (Personal, Trabajo, Ocio): ");
            TipoTarea tipo;
            while (!Enum.TryParse(Console.ReadLine(), true, out tipo))
            {
                Console.Write("Tipo inválido. Introduce (Personal, Trabajo, Ocio): ");
            }

            Console.Write("¿Prioridad alta? (s/n): ");
            bool prioridad = Console.ReadLine().ToLower() == "s";

            Tarea nuevaTarea = new Tarea(nombre, descripcion, tipo, prioridad);
            tareas.Add(nuevaTarea);

            Console.WriteLine("Tarea creada con ID: " + nuevaTarea.Id);
        }

        static void BuscarTareasPorTipo()
        {
            Console.Write("Introduce el tipo de tarea a buscar (Personal, Trabajo, Ocio): ");
            TipoTarea tipo;
            while (!Enum.TryParse(Console.ReadLine(), true, out tipo))
            {
                Console.Write("Tipo inválido. Introduce (Personal, Trabajo, Ocio): ");
            }

            var resultados = tareas.FindAll(t => t.Tipo == tipo);
            if (resultados.Count == 0)
                Console.WriteLine("No hay tareas de ese tipo.");
            else
                resultados.ForEach(t => Console.WriteLine(t));
        }

        static void EliminarTarea()
        {
            Console.Write("Introduce el ID de la tarea a eliminar: ");
            if (int.TryParse(Console.ReadLine(), out int id))
            {
                var tarea = tareas.Find(t => t.Id == id);
                if (tarea != null)
                {
                    tareas.Remove(tarea);
                    Console.WriteLine("Tarea eliminada.");
                }
                else
                {
                    Console.WriteLine("No se encontró ninguna tarea con ese ID.");
                }
            }
            else
            {
                Console.WriteLine("ID inválido.");
            }
        }

        static void ExportarTareas()
        {
            using (StreamWriter sw = new StreamWriter("tareas.txt"))
            {
                foreach (var tarea in tareas)
                {
                    sw.WriteLine(tarea.ToFileString());
                }
            }
            Console.WriteLine("Tareas exportadas a tareas.txt");
        }

        static void ImportarTareas()
        {
            if (!File.Exists("tareas.txt"))
            {
                Console.WriteLine("El archivo tareas.txt no existe.");
                return;
            }

            var lineas = File.ReadAllLines("tareas.txt");
            foreach (var linea in lineas)
            {
                var partes = linea.Split(',');
                Tarea tarea = new Tarea(partes[1], partes[2], Enum.Parse<TipoTarea>(partes[3]), bool.Parse(partes[4]));
                typeof(Tarea).GetProperty("Id").SetValue(tarea, int.Parse(partes[0]));
                tareas.Add(tarea);
            }

            Console.WriteLine("Tareas importadas correctamente.");
        }
    }
}
