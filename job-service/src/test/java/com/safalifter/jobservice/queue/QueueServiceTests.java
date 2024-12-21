package com.safalifter.jobservice.queue;


import com.safalifter.jobservice.model.Queue;
import com.safalifter.jobservice.repository.QueueRepository;
import com.safalifter.jobservice.service.QueueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class QueueServiceTests {

    @InjectMocks
    private QueueService queueService;

    @Mock
    private QueueRepository queueRepository;

    private Queue queue;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        queue = Queue.builder()
                .queueSize(5)
                .servedCount(10)
                .build();
    }

    @Test
    void shouldFetchQueueDetails() {
        when(queueRepository.findById(anyLong())).thenReturn(Optional.of(queue));

        Queue foundQueue = queueService.getQueueById(1L);

        assertThat(foundQueue).isNotNull();
        assertThat(foundQueue.getQueueSize()).isEqualTo(5);
        verify(queueRepository, times(1)).findById(1L);
    }
}

