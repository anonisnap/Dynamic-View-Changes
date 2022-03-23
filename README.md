# Dynamic-View-Changes

See your favourite celebrities in a new list :D

## Description

This is a simple Android Application, which uses the RecyclerView container to programmatically change the items shown on screen, allowing for an Endless Scroll Feed without the need to constantly create new Containers, and deleting the old ones.
The RecyclerView automatically reuses the Containers that are created, once they have been moved far enough out of the screen, and no longer serve much of a purpose

## How it works

### [ItemDisplay.java](https://github.com/anonisnap/Dynamic-View-Changes/blob/e876c37a05b58853cc6f2f9c93a3a832623785e0/app/src/main/java/com/github/anonisnap/dynamicviewchanges/ItemDisplay.java)

The `ItemDisplay` class is a very simple class, used to store information about the *items* being shown.

The Class contains the necessary fields to store basic information. These being;

```java
private String name;
private String description;
private List<String> quotes;
private char gender;
private int image;
```

The `name`, `description`, and `quotes` are simple, and just store a simple string which can later be retrieved.

The `gender` has been created as a simple `char`, this allows one to easily enter the letters `m` and `f` for Male and Female respectively, as well as having `u` currently as an Undefined.
<br>
*This could also easily be made into an Enumerator, which would allow even more flexibility in the Gender Spectrum*

The `image` is listed as an `int`, this is due to how Android Applications store and render images, where the Image has been given a simple ID. When the image is to be shown, the container, `ImageView`, is given the ID of an image to show, and then automatically renders the image defined.

<br>

### [ItemDisplayAdapter.java](https://github.com/anonisnap/Dynamic-View-Changes/blob/e876c37a05b58853cc6f2f9c93a3a832623785e0/app/src/main/java/com/github/anonisnap/dynamicviewchanges/ItemDisplayAdapter.java)

The `ItemDisplayAdapter` class serves the purpose, of converting the plain data from the class `ItemDisplay` into a Container, which can be rendered on the screen.

To do this, the `ItemDisplayAdapter` class has an extra inner class, `ViewHolder`. This inner class acts as a Data Template, containing references to the containers being rendered on Screen.

```java
// ViewHolder.java
private final LinearLayout cardBackground;
private final TextView name, desc;
private final ImageView img;
```

When the user would then scroll down or up, the individual ViewHolders would then have the information stored in their ViewContainers changed.

So when a ViewContainer would be scrolled far enough out the top of the screen, the `RecyclerView` would move the ViewHolder back to the bottom of the views, and the `ItemDisplayAdapter` class would change the information shown in the `ViewHolder`.

<br>

### [ItemDisplayList.xml](https://github.com/anonisnap/Dynamic-View-Changes/blob/e876c37a05b58853cc6f2f9c93a3a832623785e0/app/src/main/res/layout/item_display_list.xml)

The `ItemDisplayList` file is used as a Layout Template. This is the layout which the `ViewHolder` is mapped onto.

![item_display_list_design](https://user-images.githubusercontent.com/42655737/159701025-1c51c796-97aa-47fc-9cb0-c41807239b1b.png)

With the Right-most Box being locked in size, and reserved for the `ImageView`, the left section is allowed to stretch to fill the entire area, meaning a wide phone, or having it in Landscape mode, would let a lot more of the Name or Description be visible
