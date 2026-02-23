package mx.edu.itson.practica3

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductosActivity : AppCompatActivity() {

    var menu: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        val imagen: ImageView = findViewById(R.id.imageView)
        val titulo: TextView = findViewById(R.id.txtCategoria)

        val tipo = intent.getStringExtra("menuType")?.trim()?.lowercase()

        menu.clear()

        when (tipo) {

            "antojitos" -> {
                agregarProductos()
                imagen.setImageResource(R.drawable.antojitos)
                titulo.text = "Antojitos"
            }

            "especialidades" -> {
                agregarEspecialidades()
                imagen.setImageResource(R.drawable.especialidades)
                titulo.text = "Especialidades"
            }

            "combinations" -> {
                agregarCombinaciones()
                imagen.setImageResource(R.drawable.combinations)
                titulo.text = "Combinaciones"
            }

            "tortas" -> {
                agregarTortas()
                imagen.setImageResource(R.drawable.tortas)
                titulo.text = "Tortas"
            }

            "sopas" -> {
                agregarSopas()
                imagen.setImageResource(R.drawable.sopas)
                titulo.text = "Sopas"
            }

            "drinks" -> {
                agregarDrinks()
                imagen.setImageResource(R.drawable.drinks)
                titulo.text = "Drinks"
            }

            else -> {
                agregarProductos()
                imagen.setImageResource(R.drawable.antojitos)
                titulo.text = "Menu"
            }
        }

        val listView: ListView = findViewById(R.id.litview)
        val adaptador = AdaptadorProductos(this, menu)
        listView.adapter = adaptador
    }

    fun agregarProductos(){
        menu.add(Product("Quesadillas", R.drawable.quesadillas, "Rellenas con su carne favorita, servidas con ensalada", 6.29))
        menu.add(Product("Huaraches", R.drawable.huaraches, "Tortilla gruesa con frijoles y carne", 11.49))
        menu.add(Product("Gringas", R.drawable.gringas, "Tortilla de harina con queso y pastor", 8.39))
        menu.add(Product("Sincronizadas", R.drawable.sincronizadas,"Tortilla rellena con queso y jamón", 7.99))
        menu.add(Product("Sopes",R.drawable.sopes,"Tortilla gruesa cubierta de frijoles", 3.99))
        menu.add(Product("Tostadas", R.drawable.tostadas,"Tortilla frita con frijoles", 4.59))
    }

    fun agregarEspecialidades() {
        menu.add(Product("Mojarra Frita", R.drawable.mojarra, "Tilapia frita servida con lechuga, cebolla, jitomate, aguacate y tortillas. Fried tilapia served with lettuce, onions, tomatoes, avocado and tortillas.", 17.99))
        menu.add(Product("Ceviche", R.drawable.ceviche, "Tilapia, camarones, aguacate y pico de gallo servido con chips. Tilapia, shrimp, avocado and pico de gallo served with chips.", 6.99))
        menu.add(Product("Botana Camarones al Mojo de Ajo", R.drawable.botanacamarones, "Camarones salteados en mantequilla con ajo, servidos como botana. Shrimp sautéed in garlic butter, served as an appetizer.", 19.99))
    }

    fun agregarCombinaciones() {
        menu.add(Product("Taco Tradicional Combo", R.drawable.combinationtaco, "Tortillas de maíz y tu carne favorita, servido con arroz y frijoles. Corn taco, your choice of meat, served with rice and beans.", 6.99))
        menu.add(Product("Mexican Burritos", R.drawable.burritos, "Tu carne favorita en una tortilla grande de harina rellena con cebolla frita, pico de gallo, guacamole, sour cream y frijoles, acompañado de arroz. Your choice of meat in a big flour tortilla with rice, beans, grilled onions, pico de gallo, guacamole and sour cream.", 12.99))
        menu.add(Product("Los Portales Burritos", R.drawable.burritosportales, "Large flour tortilla filled with grilled cactus, pastor (seasoned pork), grilled onions, rice and beans. Served with lettuce, tomatoes, sour cream and guacamole.", 13.59))
        menu.add(Product("Cinco", R.drawable.cinco, "One hard shell taco with your choice of meat, lettuce and cheese. One burrito with your choice of meat, pico de gallo, sour cream and guacamole. Served with rice and beans.", 9.99))
        menu.add(Product("Dos Amigos", R.drawable.dosamigos, "Two hard shell tacos with your choice of meat, topped with lettuce and cheese. Served with rice and beans.", 9.99))
    }

    fun agregarTortas() {
        menu.add(Product("Torta Regular", R.drawable.torta, "All tortas come with lettuce, onions, tomatoes, avocado, sour cream, jalapeño pepper and your choice of meat.", 12.99))
        menu.add(Product("Torta Milanesa de Res o Pollo", R.drawable.tortamilanesa, "Breaded steak or chicken served in bolillo bread with traditional toppings.", 13.99))
        menu.add(Product("Torta Cubana", R.drawable.tortacubana, "Chorizo, asada, jamón, pastor y queso. Mexican sausage, steak, marinated pork, ham and cheese.", 13.99))
        menu.add(Product("Torta Mixta", R.drawable.tortamixta, "Chorizo, asada y pastor. Mexican sausage, steak and marinated pork.", 13.99))
        menu.add(Product("Small Mexican Torta", R.drawable.smallmexican, "Bolillo bread sandwich with your choice of meat, shredded lettuce, avocado, tomato, onion and sour cream.", 7.39))
    }

    fun agregarSopas() {
        menu.add(Product("Pozole", R.drawable.pozole, "Available weekends only.", 5.99))
        menu.add(Product("Menudo", R.drawable.menudo, "Available Wednesday to Sunday.", 5.99))
        menu.add(Product("Caldo de Res", R.drawable.caldores, "Traditional beef soup served with vegetables.", 5.99))
        menu.add(Product("Caldo de Camaron", R.drawable.caldocamaron, "Shrimp soup.", 13.99))
        menu.add(Product("Sopa de Mariscos", R.drawable.sopamariscos, "Seafood soup.", 19.99))
    }


    fun agregarDrinks() {
        menu.add(Product("Michelada", R.drawable.michelada, "Beer prepared with lime, sauces and spices served over ice.", 3.75))
        menu.add(Product("Jarritos", R.drawable.jarritos, "Traditional Mexican soda in assorted flavors.", 5.75))
        menu.add(Product("Caguamas", R.drawable.caguama, "Large Mexican beer bottle.", 5.75))
        menu.add(Product("Caguamas Micheladas", R.drawable.caguamamichelada, "Large Mexican beer prepared michelada style.", 2.75))
        menu.add(Product("Charolazo", R.drawable.charolazo, "Beer bucket served on a tray.", 9.75))
        menu.add(Product("Cubeta Six", R.drawable.cubetazo, "Bucket with six beers.", 9.75))
        menu.add(Product("Cubetazo", R.drawable.cubetazo, "Large bucket with assorted beers.", 9.75))
        menu.add(Product("Mexican Beer", R.drawable.mexicanbeer, "Imported Mexican beer.", 2.75))
        menu.add(Product("Sodas", R.drawable.sodas, "Soft drinks.", 2.75))
    }
    private class AdaptadorProductos(
        var contexto: Context,
        var producto: ArrayList<Product>
    ) : BaseAdapter() {

        override fun getCount(): Int {
            return producto.size
        }

        override fun getItem(position: Int): Any {
            return producto[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val vista = convertView ?: LayoutInflater.from(contexto)
                .inflate(R.layout.producto_view, parent, false)

            val prod = producto[position]

            val imagen = vista.findViewById<ImageView>(R.id.producto_img)
            val nombre = vista.findViewById<TextView>(R.id.producto_nombre)
            val desc = vista.findViewById<TextView>(R.id.producto_desc)
            val precio = vista.findViewById<TextView>(R.id.producto_precio)

            imagen.setImageResource(prod.image)
            nombre.text = prod.name
            desc.text = prod.description
            precio.text = "$${prod.price}"

            return vista
        }
    }
}
