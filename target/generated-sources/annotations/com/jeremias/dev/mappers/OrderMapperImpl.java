package com.jeremias.dev.mappers;

import com.jeremias.dev.dto.request.OrderDto;
import com.jeremias.dev.models.Order;
import com.jeremias.dev.models.OrderDetail;
import com.jeremias.dev.models.OrderStatus;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T20:36:26-0500",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class OrderMapperImpl extends OrderMapper {

    @Override
    public Order toEntity(OrderDto dto, List<OrderDetail> details, String id) {
        if ( dto == null && details == null && id == null ) {
            return null;
        }

        String id1 = null;
        if ( id != null ) {
            id1 = id;
        }

        Order order = new Order( id1 );

        if ( dto != null ) {
            order.setDate( dto.getDate() );
            if ( dto.getStatus() != null ) {
                order.setStatus( Enum.valueOf( OrderStatus.class, dto.getStatus() ) );
            }
            order.setTotal( dto.getTotal() );
        }
        if ( details != null ) {
            List<OrderDetail> list = details;
            if ( list != null ) {
                order.setDetails( new ArrayList<OrderDetail>( list ) );
            }
        }

        return order;
    }
}
