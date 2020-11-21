package main

func quickSort(arr []int) []int {
	return helper(arr, 0, len(arr) - 1)
}

func helper(arr []int, left int, right int) []int {
	if arr == nil || len(arr) == 0 {
		return make([]int, 0)
	} else if len(arr) < 2 {
		return arr
	}

	pivotIndex := partition(arr, left, right)
	if pivotIndex > left {
		helper(arr, left, pivotIndex - 1)
	}
	if pivotIndex < right {
		helper(arr, pivotIndex + 1, right)
	}

	return arr
}

func partition(arr []int, left int, right int) int {
	pivot := arr[right]
	idx := left - 1
	for i := left; i < right; i++ {
		if arr[i] <= pivot {
			idx++
			swap(arr, i, idx)
		}
	}
	swap(arr, idx + 1, right)
	return idx + 1
}

func swap(arr []int, i int, j int) {
	tmp := arr[i]
	arr[i] = arr[j]
	arr[j] = tmp
}
