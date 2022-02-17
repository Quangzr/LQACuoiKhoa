import {useEffect, useState} from "react";

const lessons = [
    {
        id: 1,
        name: 'ReactJS là gì? Tại sao nên học ReactJS'
    }, {
        id: 2,
        name: 'SPA/MPA là gì?'
    }, {
        id: 3,
        name: 'Arow function'
    }
]

function Content() {
    const [lessonId, setLessonId] = useState(1)

    useEffect(() => {

        const handleComment = ({ detail }) => {
            console.log(detail)
        }

        window.addEventListener(`lession-${lessonId}`, handleComment)

        return () => {
            window.removeEventListener(`lession-${lessonId}`, handleComment)
        }
    }, [lessonId])

    return(
        <div>
            <ul>
                {lessons.map(lesson => (
                    <li
                        key={lesson.id}
                        style={{
                            color: lessonId === lesson.id ?
                            'red' :
                            '#333'
                        }}
                        onClick={() => setLessonId(lesson.id)}
                    >
                        {lesson.name}
                    </li>
                ))}
            </ul>
        </div>
       
    )
}

export default Content