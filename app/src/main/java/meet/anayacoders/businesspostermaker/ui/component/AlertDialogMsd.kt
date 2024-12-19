package meet.anayacoders.businesspostermaker.ui.component

//
//@Composable
//fun AlertDialogMsd(
//    itemType: String,
//    poster: Poster,
//    onConfirm: (String) -> Unit,
//    onDismiss: () -> Unit,
//    viewModel: PosterViewModel
//) {
//    AlertDialog(
//        onDismissRequest = {
//            onDismiss()
//        },
//        dismissButton = {
//            TextButton(onClick = {
//                onDismiss()
//            }) {
//                Text(text = "Cancel")
//            }
//        },
//        confirmButton = {
//            TextButton(onClick = {
//                if (itemType == Constants.ITEM_TYPE_GENERAL_EVENT) {
//                    viewModel.deletePoster(poster)
//                    val uiState = viewModel.addPosterUiState
//                    onConfirm(
//                        when {
//                            uiState.isLoading -> "Loading"
//                            uiState.success != "" -> uiState.success
//                            uiState.error != "" -> uiState.error
//                            else -> "Something went wrong"
//                        }
//                    )
//
//                } else if (itemType == Constants.ITEM_TYPE_UPCOMING_EVENT) {
//                    //TODO: Delete for upcoming events poster
//                } else if (itemType == Constants.ITEM_TYPE_CATEGORY) {
//                    //TODO: Delete for category poster
//                }
//                onDismiss()
//            }) {
//                Text(text = "Confirm", color = MaterialTheme.colorScheme.error)
//            }
//        },
//        title = {
//            Text(text = "Are you sure want to delete?")
//        },
//        text = {
//            Text(text = "It will delete item permanently, it can not be restored!")
//        },
//        icon = {
//            Icon(imageVector = Icons.Default.Delete, contentDescription = "delete")
//        }
//    )
//}