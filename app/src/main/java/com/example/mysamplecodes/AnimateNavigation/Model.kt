package com.example.mysamplecodes.AnimateNavigation

import com.example.mysamplecodes.R

data class Vegetables(
    val code:String,
    val image: Int,
    val name: String,
    val measurement: String,
    val calories: String,
    val details: String,
    val benefits: List<String> = emptyList(),
    val drawback: List<String> = emptyList()
)

val vegList = listOf(
    Vegetables(
        code = "VEG001",
        image = R.drawable.onion,
        name = "Onion",
        measurement = "1 cup (115 g)",
        calories = "46 calories",
        benefits = listOf("Blood sugar regulation", "Bone health", "Reduction of cancer risk"),
        drawback = listOf("Onion intolerance and allergy", "Eye and mouth irritation"),
        details = "Onions contain many antioxidants and sulfur-containing compounds. They have been linked to a reduced risk of cancer, lower blood sugar levels, and improved bone health.\n" +
                "\n" +
                "Onions (Allium cepa) are bulb-shaped vegetables that grow underground.\n" +
                "\n" +
                "Also known as bulb onions or common onions, they are grown worldwide and are closely related to chives, garlic, scallions, shallots, and leeks.\n" +
                "\n" +
                "Commonly used as a flavoring or side dish, onions are a staple food in many cuisines. They can be baked, boiled, grilled, fried, roasted, sautéed, powdered, or eaten raw.\n" +
                "\n" +
                "Onions vary in size, shape, and color, but the most common types are white, yellow, and red. The taste ranges from mild and sweet to sharp and spicy, depending on the variety and season.\n" +
                "\n" +
                "Onions can also be consumed when immature before the bulb reaches full size. They are then called scallions, spring onions, or summer onions."
    ),
    Vegetables(
        code = "VEG002",
        image = R.drawable.spinach,
        name = "Spinach",
        measurement = "1 cup (30 g)",
        calories = "7 calories",
        benefits = listOf("Oxidative stress","Eye health", "Cancer prevention", "Blood pressure"),
        drawback = listOf("Kidney stones", "Blood clotting"),
        details = "Eating spinach may benefit eye health, reduce oxidative stress, help prevent cancer, and reduce blood pressure levels.\n" +
                "\n" +
                "Spinach (Spinacia oleracea) is a leafy green vegetable that originated in Persia.\n" +
                "\n" +
                "It belongs to the amaranth family and is related to beets and quinoa. What’s more, it’s considered very healthy, as it’s loaded with nutrients and antioxidants.\n" +
                "\n" +
                "There are many ways to prepare spinach. You can buy it canned or fresh and eat it cooked or raw. It’s delicious either on its own or in other dishes."
    ),
    Vegetables(
        code = "VEG003",
        image = R.drawable.potato,
        name = "Potatoes",
        measurement = "1 cup diced (150 g)",
        calories = "116  calories",
        benefits = listOf("Heart health","Fullness and weight management"),
        drawback = listOf("Allergies", "Toxins", "Acrylamides"),
        details = "Potatoes contain vitamins and minerals, including vitamin C and potassium. They may provide health benefits, depending on how they are prepared.\n" +
                "\n" +
                "Potatoes are underground tubers that grow on the roots of the potato plant, Solanum tuberosum.\n" +
                "\n" +
                "This plant is from the nightshade family and related to tomatoes and tobacco. Native to South America, potatoes were brought to Europe in the 16th century and are now grown in countless varieties worldwide.\n" +
                "\n" +
                "They’re generally eaten boiled, baked, or fried and frequently served as a side dish or snack. Common potato-based foods and food products include french fries, potato chips, and potato flour."
    ),
    Vegetables(
        code = "VEG004",
        image = R.drawable.broccoli,
        name = "Broccoli",
        measurement = "1 cup (91 g)",
        calories = "31 calories",
        benefits = listOf("Cancer prevention", "Lower cholesterol levels", "Eye health",),
        drawback = listOf("Thyroid problems", "Blood thinners"),
        details = "Broccoli is a cruciferous vegetable rich in antioxidants and other beneficial plant compounds. It may also offer several benefits, especially for eye health, heart health, and disease prevention.\n" +
                "\n" +
                "These vegetables are known for their beneficial health effects.\n" +
                "\n" +
                "Broccoli is high in many nutrients, including fiber, vitamin C, vitamin K, iron, and potassium.\n" +
                "\n" +
                "This green veggie can be enjoyed both raw and cooked, but recent research shows that gentle steaming provides the most health benefits."
    ),
    Vegetables(
        code = "VEG005",
        image = R.drawable.carrot,
        name = "Carrots",
        measurement = "1 cup (128 g)",
        calories = "53 calories",
        benefits = listOf("Reduced risk of cancer","Lower blood cholesterol", "Weight loss", "Eye health"),
        drawback = listOf("Allergy"),
        details = "Carrots contain many nutrients, including beta carotene and antioxidants, that may support your overall health as part of a nutrient-rich diet.\n" +
                "\n" +
                "It is crunchy, tasty, and highly nutritious. Carrots are a particularly good source of beta carotene, fiber, vitamin K1, potassium, and antioxidants (1Trusted Source).\n" +
                "\n" +
                "They also have a number of health benefits. They’re a weight-loss-friendly food and have been linked to lower cholesterol levels and improved eye health.\n" +
                "\n" +
                "What’s more, their carotene antioxidants have been linked to a reduced risk of cancer.\n" +
                "\n" +
                "Carrots are found in many colors, including yellow, white, orange, red, and purple.\n" +
                "\n" +
                "Orange carrots get their bright color from beta carotene, an antioxidant that your body converts into vitamin A."
    ),
    Vegetables(
        code = "VEG006",
        image = R.drawable.pumpkin,
        name = "Pumpkin",
        measurement = "1 cup (116 g)",
        calories = "30 calories",
        benefits = listOf("Immunity", "Eye health", "Skin health", "Heart health", "Metabolic health"),
        drawback = emptyList(),
        details = "Pumpkin is a healthy, versatile vegetable that’s loaded with a variety of nutrients, including fiber, vitamins, minerals, and antioxidants. Most of the health benefits of pumpkin are focused on its fiber content and micronutrients, including beta carotene and vitamin A.\n" +
                "\n" +
                "Pumpkin is a favorite autumn ingredient, but you may wonder whether it’s healthy.\n" +
                "\n" +
                "Indeed, pumpkin is very nutritious and low in calories. Plus, it’s more versatile than you may think. It can be cooked into savory and sweet dishes alike."
    ),
    Vegetables(
        code = "VEG007",
        image = R.drawable.tomato,
        name = "Tomatoes",
        measurement = "1 cup (180 g)",
        calories = "36 calories",
        benefits = listOf("Heart health", "Cancer prevention", "Skin health"),
        drawback = listOf("Allergy"),
        details = "Tomatoes are the major dietary source of the antioxidant lycopene, which has been linked to many health benefits, including reduced risk of heart disease and cancer.\n" +
                "\n" +
                "The tomato (Solanum lycopersicum) is a fruit from the nightshade family native to South America.\n" +
                "\n" +
                "Despite botanically being a fruit, it’s generally eaten and prepared like a vegetable.\n" +
                "\n" +
                "They are a great source of vitamin C, potassium, folate, and vitamin K.\n" +
                "\n" +
                "Usually red when mature, tomatoes can also come in a variety of colors, including yellow, orange, green, and purple. What’s more, many subspecies of tomatoes exist with different shapes and flavor."
    ),
    Vegetables(
        code = "VEG008",
        image = R.drawable.drumstick,
        name = "Drumsticks",
        measurement = "1 cup (100 g)",
        calories = "92 calories",
        benefits = listOf("Aids In Managing Diabetes","Aids In Wound Healing","Guards Against Respiratory Illness", "Assistance With Blood Purification", "Good For The Kidney"),
        drawback = emptyList(),
        details = "A tropical tree that can withstand drought is called a drumstick (also known as Moringa oleifera). Flowers, pods, and leaves are only some of the parts of the tree that are valued. Due to the benefits of the pods and leaves in curing a variety of diseases, drumsticks are crucial to traditional remedies.\n" +
                "\n" +
                "Nearly all south Indian kitchens have drumstick pods and leaves. Dal, sambar, and drumstick curry are just a few of the dishes that call for drumstick pods. Drumstick leaves can be eaten, just like spinach. They can be added to juices, stir-fried vegetables, and lentils.\n" +
                "\n" +
                "Most likely, one of these vitamin-rich and health-promoting vegetables is the drumstick. Drumsticks are a great complement to a diet plan for weight loss. Although drumsticks are most frequently eaten with meals, there are many more ways to include them in your diet and benefit from them."
    ),

    )

