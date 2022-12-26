package com.example.gumbuddy.db

import com.example.gumbuddy.R

object DataSource {

    fun getGroupsData(): ArrayList<MuscleGroup>{
       return arrayListOf(
            MuscleGroup(
                1,
                "Грудь",
                R.drawable.icon_grud
            ),
            MuscleGroup(
                2,
                "Спина",
                R.drawable.icon_grud
            ),
            MuscleGroup(
                3,
                "Ноги",
                R.drawable.icon_grud
            ),
            MuscleGroup(
                4,
                "Ягодичные",
                R.drawable.icon_grud
            ),
            MuscleGroup(
                5,
                "Дельты",
                R.drawable.icon_grud
            ),
            MuscleGroup(
                6,
                "Руки бицепс",
                R.drawable.icon_grud
            ),
            MuscleGroup(
                7,
                "Руки трицепс",
                R.drawable.icon_grud
            ),
            MuscleGroup(
                8,
                "Предплечье",
                R.drawable.icon_grud
            ),
            MuscleGroup(
                9,
                "Функциональные упражнения",
                R.drawable.icon_grud
            ),
            MuscleGroup(
                10,
                "Кардио",
                R.drawable.icon_grud
            ),
            MuscleGroup(
                11,
                "Растяжка",
                R.drawable.icon_grud
            ),
        )
    }

    fun getExerciseData(): ArrayList<Exercise> {
        return arrayListOf(
            Exercise(
                1,
                1,
                "Жим штанги лёжа на горизонтальной скамье",
                "Это базовое упражнение в бодибилдинге и пауэрлифтинге со свободными весами, предназначенное для развития мышц груди, рук(трицепсов) и переднего пучка дельтовидных мышц.",
                R.drawable.icon_zhim,
                R.drawable.zhim
            ),
            Exercise(
                2,
                1,
                "Жим Свенда",
                "Жим Свенда - эффективное упражнение для развития грудных мышц. В отличие от обычного жима позволяет максимально свести локти и, тем самым, получить пиковую нагрузку на мышцы груди. Цель упражнения: развитие силовых показателей, улучшение нейромышечной связи и мышечного контроля, возможность 'шокировать' мышцы и исключить привыкание к нагрузкам, преодоление плато и застоя в развитии грудных мышц.",
                R.drawable.icon_zhim,
                R.drawable.zhim
            ),
            Exercise(
                3,
                1,
                "Жим Свенда с Т-грифом",
                "Жим Свенда - эффективное упражнение для развития грудных мышц. В отличие от обычного жима позволяет максимально свести локти и, тем самым, получить пиковоую нагрузку на мышщы груди. Цель упражнения: развитие силовых показателей, улучшение нейромышечной связи и мышечного контроля, возможность 'шокировать' мышцы и исключить привыкание к нагрузкам, преодоление плато и застоя в развитии грудных мышц. Использование Т-грифа позволяет сосредоточиться на проработке грудных мышц, не отвлекаясь на удержание равновесия.",
                R.drawable.icon_zhim,
                R.drawable.zhim
            ),
        )
    }

}