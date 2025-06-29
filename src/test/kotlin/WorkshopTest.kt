package org.example // Add package declaration

import kotlin.test.Test
import kotlin.test.assertEquals

class WorkshopTest {

    // --- Tests for Workshop #1: Unit Converter ---

    // celsius input: 20.0
    // expected output: 68.0
    @Test
    fun `test celsiusToFahrenheit with positive value`() {
        // Arrange: ตั้งค่า input และผลลัพธ์ที่คาดหวัง
        val celsiusInput = 20.0
        val expectedFahrenheit = 68.0

        // Act: เรียกใช้ฟังก์ชันที่ต้องการทดสอบ
        val actualFahrenheit = celsiusToFahrenheit(celsiusInput)

        // Assert: ตรวจสอบว่าผลลัพธ์ที่ได้ตรงกับที่คาดหวัง
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001, "20°C should be 68°F")
    }

    // celsius input: 0.0
    // expected output: 32.0
    @Test
    fun `test celsiusToFahrenheit with zero`() {
        // Arrange
        val celsiusInput = 0.0
        val expectedFahrenheit = 32.0

        // Act
        val actualFahrenheit = celsiusToFahrenheit(celsiusInput)

        // Assert
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001, "0°C should be 32°F")
    }

    // celsius input: -10.0
    // expected output: 14.0
    @Test
    fun `test celsiusToFahrenheit with negative value`() {
        // Arrange
        val celsiusInput = -10.0
        val expectedFahrenheit = 14.0

        // Act
        val actualFahrenheit = celsiusToFahrenheit(celsiusInput)

        // Assert
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001, "-10°C should be 14°F")
    }

    // test for kilometersToMiles function
    // kilometers input: 1.0
    // expected output: 0.621371
    @Test
    fun `test kilometersToMiles with one kilometer`() {
        // Arrange
        val kilometersInput = 1.0
        val expectedMiles = 0.621371

        // Act
        val actualMiles = kilometersToMiles(kilometersInput)

        // Assert
        assertEquals(expectedMiles, actualMiles, 0.000001, "1 kilometer should be approximately 0.621371 miles")
    }

    // --- Tests for Workshop #1: Unit Converter End ---

    ---

    // --- Tests for Workshop #2: Data Analysis Pipeline ---
    // ทำการแก้ไขไฟล์ Workshop2.kt ให้มีฟังก์ชันที่ต้องการทดสอบ
    // เช่น ฟังก์ชันที่คำนวณผลรวมราคาสินค้า Electronics ที่ราคา > 500 บาท
    // ในที่นี้จะสมมุติว่ามีฟังก์ชันชื่อ calculateTotalElectronicsPriceOver500 ที่รับ List<Product> และคืนค่า Double
    // จงเขียน test cases สำหรับฟังก์ชันนี้ โดยตรวจสอบผลรวมราคาสินค้า Electronics ที่ราคา > 500 บาท
    // 🚨

    @Test
    fun `test calculateTotalElectronicsPriceOver500`() {
        // Arrange: สมมติข้อมูลสินค้าตามโจทย์ Workshop 2
        val products = listOf(
            Product(name = "Laptop", price = 35000.0, category = "Electronics"),
            Product(name = "Smartphone", price = 25000.0, category = "Electronics"),
            Product(name = "T-shirt", price = 450.0, category = "Apparel"),
            Product(name = "Monitor", price = 7500.0, category = "Electronics"),
            Product(name = "Keyboard", price = 499.0, category = "Electronics"), // ราคาไม่เกิน 500
            Product(name = "Jeans", price = 1200.0, category = "Apparel"),
            Product(name = "Headphones", price = 1800.0, category = "Electronics")
        )
        // Expected: Laptop (35000.0) + Smartphone (25000.0) + Monitor (7500.0) + Headphones (1800.0)
        // Total = 35000 + 25000 + 7500 + 1800 = 69300.0
        val expectedTotal = 69300.0

        // Act
        val actualTotal = calculateTotalElectronicsPriceOver500(products)

        // Assert
        assertEquals(expectedTotal, actualTotal, 0.001, "Total price of Electronics over 500 should be 69300.0")
    }

    // จงเขียน test cases เช็คจำนวนสินค้าที่อยู่ในหมวด 'Electronics' และมีราคามากกว่า 500 บาท
    // 🚨

    @Test
    fun `test countElectronicsOver500`() {
        // Arrange: สมมติข้อมูลสินค้าตามโจทย์ Workshop 2
        val products = listOf(
            Product(name = "Laptop", price = 35000.0, category = "Electronics"),
            Product(name = "Smartphone", price = 25000.0, category = "Electronics"),
            Product(name = "T-shirt", price = 450.0, category = "Apparel"),
            Product(name = "Monitor", price = 7500.0, category = "Electronics"),
            Product(name = "Keyboard", price = 499.0, category = "Electronics"), // ราคาไม่เกิน 500
            Product(name = "Jeans", price = 1200.0, category = "Apparel"),
            Product(name = "Headphones", price = 1800.0, category = "Electronics")
        )
        // Expected: Laptop, Smartphone, Monitor, Headphones (4 products)
        val expectedCount = 4

        // Act
        val actualCount = countElectronicsOver500(products)

        // Assert
        assertEquals(expectedCount, actualCount, "Count of Electronics over 500 should be 4")
    }

    // --- Tests for Workshop #2: Data Analysis Pipeline End ---
}

// Below are placeholder implementations for the functions and data class used in the tests.
// In your actual project, these should be in their respective source files (e.g., Workshop1.kt, Workshop2.kt)
// within the 'org.example' package.

// From Workshop #1 (e.g., in Workshop1.kt or the same file as main)
fun celsiusToFahrenheit(celsius: Double): Double {
    return celsius * 9.0 / 5.0 + 32
}

fun kilometersToMiles(kilometers: Double): Double {
    return kilometers * 0.621371
}

// From Workshop #2 (e.g., in Workshop2.kt)
data class Product(val name: String, val price: Double, val category: String)

fun calculateTotalElectronicsPriceOver500(products: List<Product>): Double {
    return products
        .filter { it.category == "Electronics" && it.price > 500.0 }
        .sumOf { it.price }
}

fun countElectronicsOver500(products: List<Product>): Int {
    return products
        .count { it.category == "Electronics" && it.price > 500.0 }
}