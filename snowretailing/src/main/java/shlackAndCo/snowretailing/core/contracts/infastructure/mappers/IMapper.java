package shlackAndCo.snowretailing.core.contracts.infastructure.mappers;

public interface IMapper<TSource,TDestination> {
    TDestination Map(TSource sourceValue);
}
