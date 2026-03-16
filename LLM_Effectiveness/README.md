# LLM Implementation

GPT-4o was utilized for this activity.

## Activity A - Playlist Manager

ArrayList of songs, add/remove/find/sort, no duplicates.

## Solo Small Function Names/Inputs/Outputs

``` Java
Playlist = ArrayList    # An empty arrayList to hold a list of song names

Playlist.addSong("Song Name")   # Provides a new song to the end of the arrayList
Playlist.findSong("Song Name")  # Searches for a song name in a Playlist, returns the index of the song name based on result (-1 if not found)
Playlist.removeSong("Song Name")    # Removes a song name in a Playlist if it exists (could use findSong)
Playlist.sort   # Sort the playlist alphabetically.
Playlist.removeDuplicates   # Removes duplicates from a playlist, returning an arrayList of the removed duplicates
```

## LLM Informed Small Function Names/Inputs/Outpus

``` Java
ArrayList<String> playlist;   // Stores song titles
```

``` Java
addSong(String title)
```

Preconditions:
title is not null or empty
playlist has been initialized
Postconditions:
title is appended to the end of playlist
playlist.size() increases by 1

``` Java
findSongIndex(String title)
```

Preconditions:
title is not null or empty
playlist has been initialized
Postconditions:
Returns the index of title if found
Returns -1 if the song is not in the playlist

``` Java
removeSong(String title)
```

Preconditions:
title is not null or empty
playlist has been initialized
Postconditions:
The first occurrence of title is removed if present
playlist.size() decreases by 1 if removal occurs

``` Java
sortPlaylist()
```

Preconditions:
title is not null or empty
Playlist contains comparable elements (String)
Postconditions:
Songs are ordered alphabetically (A-Z)
playlist.size() remains unchanged

``` Java
removeDuplicateSongs()
```

Preconditions:
title is not null or empty
Playlist may contain duplicate titles
Postconditions:
Playlist contains only unique song titles.
Returns ArrayList(String) of removed duplicates.

``` Java
boolean containsSong(String title)
```

Quickly checks if a song already exists in the playlist (useful for validation or preventing duplicates).

Did functional decomposition with LLMs help you structure your program more effectively?
Moderately

How often did the LLM suggest useful function decompositions that you hadn't condiered?
Often

## Activity B - Recursive Sum

``` Java
import java.util.ArrayList;

public class ActivityB {

    public ActivityB() {
        ArrayList<Integer> ArrayList = new ArrayList<Integer>();
        ArrayList.add(1);
        ArrayList.add(2);
        ArrayList.add(3);
        int sum = recursive_sum(ArrayList);
        System.out.println("The sum of the array list is: " + sum);
    }

    public int recursive_sum(ArrayList<Integer> ArrayList) {
        if (ArrayList.size() == 0) {
            return 0;
        } else {
            int lastElement = ArrayList.get(ArrayList.size() - 1);
            ArrayList.remove(ArrayList.size() - 1);
            return lastElement + recursive_sum(ArrayList);
        }
    }
}
```

Did the LLM help clarify difficult recursive concepts better than traditional methods?
Moderately

How useful was the LLM in debugging recursive implementations?
Very useful

## Activity C - Merge Sort

``` Java
import java.util.ArrayList;

public class ActivityC {
    public ActivityC() {
        ArrayList<Integer> ArrayList = new ArrayList<Integer>();
        ArrayList.add(5);
        ArrayList.add(2);
        ArrayList.add(9);
        ArrayList.add(1);
        ArrayList.add(3);
        System.out.println("Original array list: " + ArrayList);
        ArrayList<Integer> sortedArrayList = mergeSort(ArrayList);
        System.out.println("Sorted array list: " + sortedArrayList);
    }

    public ArrayList<Integer> mergeSort(ArrayList<Integer> ArrayList) {
        if (ArrayList.size() <= 1) {
            return ArrayList;
        }
        int mid = ArrayList.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(ArrayList.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(ArrayList.subList(mid, ArrayList.size()));
        return merge(mergeSort(left), mergeSort(right));
    }

    public ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}
```

Did the LLM improve your understanding of sorting algorithm complexities?
Extremely

Did LLM-generated explanations of Big-O notation help you analyze algorithm efficiency better?
Moderately

## Reflection Questions

Has using an LLM improved your fundamental data structure programming skills?
Extremely

How likely are you to use LLMs for programming-related tasks outside of this course?
Extremely likely
