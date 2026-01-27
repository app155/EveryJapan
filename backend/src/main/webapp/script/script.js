function deleteToTimetable(subjectId) {
		fetch('/timetable/' + selectTableId + '/delSubject', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({
				subjectId: subjectId
			})
		})
		.then(res => res.json())
		.then(result => {
			if (result.success) {
				selectTable(selectTableId, selectTableName);
			}
		})
		.catch(err => {
			console.error(err);
			alert('시간표에 과목 삭제 실패...');
		});
	}
	