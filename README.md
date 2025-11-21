# 🐉 Dragons or Treasure – Java Console Adventure Game

The **Dragons or Treasure** project is a Java console-based adventure game designed to demonstrate essential **Object-Oriented Programming** and **method-based design** through two versions: a basic single-player mode and an extended multi-player mode.  
The main focus is clean structure, logical game flow, and clear use of Java fundamentals without unnecessary complexity.

---

## 📌 Overview

The world is a curved 7×7 grid filled with randomized elements:

- 🐉 Dragons  
- 💣 Traps  
- 💰 Treasures  
- 🚪 Escape exits  
- ⚠️ Cliff exits  

Players move around the map using simple keyboard input and interact with whatever appears on their tile.  
Each tile affects the game state in different ways, and survival depends on movement decisions and resource management.

---

## 🎮 DATP1 – Single Player Version

DATP1 features one player navigating the world:

- Player starts on a random coordinate  
- Encounters dragons, traps, cliffs, treasures, and escape points  
- Moves using `W A S D`  
- Core logic is implemented through methods such as movement validation, event handling, and treasure puzzles  

This version highlights:

- Input handling with `Scanner`  
- Grid navigation  
- Random event generation  
- Simple game loop structure  
- Modular method usage  

---

## 🎮 DATP2 – Multi-Player Version

DATP2 expands the same concept to support **N players**, each with their own statistics and game state:

- Positions stored in arrays  
- Turn-based gameplay  
- Dead or escaped players are automatically skipped  
- At the end, the program prints statistics such as:
  - Highest treasure total  
  - Most treasures collected  
  - Most dragon encounters  
  - Most trap visits  

This version demonstrates:

- Array-based state management  
- Iteration over multiple players  
- Turn-based logic  
- Comparative evaluation at the end of the game  

---

## 🧱 Core Programming Concepts Used

### 🔹 Method-Based Design  
All major actions (movement, encounters, tile logic) are handled via modular methods for clean structure.

### 🔹 Random Generation  
Randomized spawn locations for dragons, traps, treasures, cliffs, and escape tiles increase replayability.

### 🔹 Console Input  
Uses `Scanner` for movement and interaction prompts.

### 🔹 Flow Control  
Game logic is built around loops, condition checks, and switch-case structures to drive turns and events.
