<template>
    <v-data-table
        :headers="headers"
        :items="items"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>
</template>

<script>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { VDataTable } from 'vuetify/labs/VDataTable'

export default {
    name: 'ManuscriptListView',
    components: {
        VDataTable,
    },
    props: {
        value: Object,
        editMode: Boolean,
        isNew: Boolean
    },
    setup() {
        const headers = ref([
            // 필드 디스크립터를 기반으로 헤더 설정
            { title: "manuscriptId", key: "manuscriptId" },
            { title: "title", key: "title" },
            { title: "content", key: "content" },
            { title: "createdDate", key: "createdDate" },
            { title: "lastModified", key: "lastModified" },
            { title: "authorId", key: "authorId" },
            { title: "status", key: "status" },
        ]);

        const items = ref([]);

        onMounted(async () => {
            try {
                const response = await axios.get('/manuscriptLists');
                const data = response.data._embedded.manuscriptLists;
                data.forEach(obj => {
                    obj.id = obj._links.self.href.split("/").pop();
                });
                items.value = data;
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        });

        return {
            headers,
            items
        };
    }
}
</script>
