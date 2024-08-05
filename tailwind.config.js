// setup reference: https://medium.com/@jyad1866/adding-tailwind-css-to-the-spring-boot-bbf289d8ca62
/** @type {import('tailwindcss').Config} */
module.exports = {
    mode: process.env.NODE_ENV? 'jit' : undefined,
    content: ["./src/main/resources/**/*.{html,js}"],
    darkMode: "media",
    theme: {
        extend: {},
    },
    variants: {
        extend: {},
    },
    plugins: [],
}