package main

func selectionSort(arr []int) []int {
	if arr == nil || len(arr) == 0 {
		return make([]int, 0)
	}

	for i := 0; i < len(arr); i++ {
		minIndex := i
		for j := i; j < len(arr); j++ {
			if arr[j] < arr[minIndex] {
				minIndex = j
			}
		}
		tmp := arr[minIndex]
		arr[minIndex] = arr[i]
		arr[i] = tmp
	}

	return arr
}
